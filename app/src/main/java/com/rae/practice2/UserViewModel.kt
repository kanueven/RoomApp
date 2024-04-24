package com.rae.practice2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rae.practice2.data.User
import com.rae.practice2.data.UserDatabase
import com.rae.practice2.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository):ViewModel(){
    //states
   val allUsers : Flow<List<User>> = userRepository.getAll

    private val _state = MutableStateFlow(UserState())
    // Expose immutable state to the UI
    val userState: StateFlow<UserState> = _state


   fun onEvent(event: UserEvent){
       when(event){
           is UserEvent.DeleteUser -> {
               viewModelScope.launch {
                   userRepository.deleteUser(event.user)
               }

           }
           UserEvent.HideDialog -> {
               _state.update { it.copy(
                   isAdding = false
               ) }
           }
           UserEvent.SaveContact -> {
               val firstName = userState.value.firstName
               val lastName = userState.value.lastName
               val age = userState.value.age
               if (firstName.isBlank() || lastName.isBlank() ||age.isBlank()){
                   return
               }
               val user = User(
                   firstName  = firstName,
                   lastName = lastName,
                   age = age
               )
               viewModelScope.launch {
                   userRepository.addUser(user)
               }
               _state.update { it.copy(
                   isAdding = false,
                   firstName = "",
                   lastName = "",
                   age = ""
               ) }

           }


           is UserEvent.SetAge -> {
               _state.update { it.copy(
                   age = event.age
               ) }
           }
           is UserEvent.SetFirstName -> {
               _state.update { it.copy(
                   firstName = event.firstName
               ) }

           }
           is UserEvent.SetLastName -> {
               _state.update { it.copy(
                   lastName = event.lastName
               ) }
           }
           UserEvent.ShowDialog -> {
               _state.update { it.copy(
                   isAdding = true
               ) }
           }
       }
   }
}
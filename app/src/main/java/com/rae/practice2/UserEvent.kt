package com.rae.practice2

import com.rae.practice2.data.User

sealed interface UserEvent {
    object SaveContact: UserEvent
    data class SetFirstName(val firstName:String):UserEvent
    data class SetLastName(val lastName:String):UserEvent
    data class SetAge(val age:String):UserEvent
    object ShowDialog : UserEvent
    object HideDialog: UserEvent
    data class DeleteUser(val user: User): UserEvent
}
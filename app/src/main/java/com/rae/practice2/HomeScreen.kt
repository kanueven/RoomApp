package com.rae.practice2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    state:UserState,
    onEvent: (UserEvent) -> Unit
){
    Scaffold(
        floatingActionButton = { ButtonFloat() }
    ) {padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ){
            items(state.user){
                Row (modifier = Modifier.fillMaxWidth())
                {
                    Column(modifier = Modifier.weight(1f))
                    {
                        Text(text = "${ state.firstName } ${state.lastName}",
                            fontSize = 15.sp)
                        Text(text = state.age)

                    }
                    IconButton(
                        onClick = {
                            onEvent(UserEvent.DeleteUser(user))
                        }) {
                        Icon(imageVector = Icons.Default.Delete,
                            contentDescription ="Delete" )

                    }
                }
            }

            
        }

    }
}

@Composable
fun ButtonFloat(onEvent: (UserEvent) -> Unit) {
    FloatingActionButton(
        onClick = {
                  onEvent(UserEvent.ShowDialog)
        },
        shape = FloatingActionButtonDefaults.shape,
        containerColor = Color.Red,

        ) {
        Icon(imageVector = Icons.Default.Add,
            contentDescription ="Add new Users" ,
            tint = Color.White)
        
    }

}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()

}

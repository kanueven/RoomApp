package com.rae.practice2

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(){
    Scaffold(
        floatingActionButton = { ButtonFloat() }
    ) {

    }
}

@Composable
fun ButtonFloat() {

}
@Preview
@Composable
fun HomeScreenPreview(){

}

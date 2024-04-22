package com.rae.practice2

private object Route {
    const val HOME ="home"
    const val ADDUSER ="add_user"
}
sealed class Screen(val route: String){
    object Home : Screen(Route.HOME)
    object NewUser : Screen(Route.ADDUSER)
}




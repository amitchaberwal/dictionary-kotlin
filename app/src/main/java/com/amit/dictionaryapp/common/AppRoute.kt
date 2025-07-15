package com.amit.dictionaryapp.common

sealed class AppRoute(val route: String){
    data object Home: AppRoute("home")
}

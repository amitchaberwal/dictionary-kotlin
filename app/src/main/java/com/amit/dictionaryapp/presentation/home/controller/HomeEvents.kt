package com.amit.dictionaryapp.presentation.home.controller

sealed class HomeEvents {
    data class ShowSnackbar(val message:String): HomeEvents()
    data class GetWordDefination(val word: String): HomeEvents()
}
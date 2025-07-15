package com.amit.dictionaryapp.presentation.home.controller

import com.amit.dictionaryapp.domain.model.WordModel

data class HomeState(
    val isLoading: Boolean = false,
    val wordModelList: List<WordModel> = emptyList()
)

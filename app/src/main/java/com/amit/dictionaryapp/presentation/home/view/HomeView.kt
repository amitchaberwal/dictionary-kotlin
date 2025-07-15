package com.amit.dictionaryapp.presentation.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.amit.dictionaryapp.presentation.home.controller.HomeViewModel


@Composable
fun HomeView(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
    ) {
    val state = viewModel.state.value
    Scaffold(
        containerColor = Color.Red
    ){ innerPadding ->
        Column (modifier = Modifier.fillMaxSize().padding(innerPadding)){

        }
    }
}
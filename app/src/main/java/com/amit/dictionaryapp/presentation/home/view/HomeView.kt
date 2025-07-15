package com.amit.dictionaryapp.presentation.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.amit.dictionaryapp.presentation.home.controller.HomeViewModel


@Composable
fun HomeView(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
    ) {
    val state = viewModel.state.value
    var inputText by remember { mutableStateOf("") }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ){ innerPadding ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)){
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier.fillMaxWidth().weight(2f),
                    value = inputText,
                    onValueChange = {
                        inputText = it
                    }
                )
                Button(
                    modifier = Modifier.weight(1f).size(height = 50.dp, width = 120.dp),
                    onClick = {
                        viewModel.getWordList(inputText)
                    }
                ) {
                    Text(
                        "Search"
                    )
                }
            }
        }
    }
}
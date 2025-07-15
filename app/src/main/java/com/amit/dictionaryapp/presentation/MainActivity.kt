package com.amit.dictionaryapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.amit.dictionaryapp.common.AppNavigation
import com.amit.dictionaryapp.presentation.ui.theme.DictionaryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            DictionaryAppTheme(darkTheme = true) {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}

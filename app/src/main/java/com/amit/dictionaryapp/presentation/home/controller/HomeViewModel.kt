package com.amit.dictionaryapp.presentation.home.controller

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amit.dictionaryapp.common.Resource
import com.amit.dictionaryapp.domain.use_case.GetWordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWordUseCase: GetWordUseCase
) :ViewModel() {
    // define state
    private val _state = mutableStateOf(HomeState())
    var state: State<HomeState> = _state
    // define events

    private val _eventFlow = MutableSharedFlow<HomeEvents>()
    var eventFlow = _eventFlow.asSharedFlow()

    fun getWordList(word: String){
        getWordUseCase(word).onEach { result ->
            when(result){
               is Resource.Success -> {
                   _state.value = _state.value.copy(
                       wordModelList = result.data?: emptyList(),
                       isLoading = false
                       )
               }
                is Resource.Error -> {
                    _state.value = _state.value.copy(wordModelList = result.data?: emptyList(),
                        isLoading = false
                        )
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        wordModelList = result.data?: emptyList(),
                        isLoading = true
                        )
                }
            }
        }.launchIn(viewModelScope)
    }
}
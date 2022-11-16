package com.example.rickandmortychallenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortychallenge.data.repository.CharacterRepository
import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _spinner = MutableStateFlow(false)
    val spinner: StateFlow<Boolean> get() = _spinner

    val characters: Flow<List<Character>> get() = repository.getCharacters()

    init {
        nextPage(true)
    }
    fun nextPage(fromInt: Boolean=false){
        viewModelScope.launch {
            repository.checkRequireNewPage(fromInt).collect{
                when (it){
                    is Resource.Loading-> _spinner.value = true
                    else -> _spinner.value = false
                }
            }
        }
    }
}
package com.example.rickandmortychallenge.ui.viewmodel


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rickandmortychallenge.data.repository.CharacterRepository
import com.example.rickandmortychallenge.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){


    val idCharacter: Int = savedStateHandle.get<Int>("characterId") ?:0

    val character: Flow<Character> = repository.getCharacter(idCharacter)

}
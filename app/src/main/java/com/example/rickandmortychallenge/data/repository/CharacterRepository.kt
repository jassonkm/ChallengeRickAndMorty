package com.example.rickandmortychallenge.data.repository

import kotlinx.coroutines.flow.Flow
import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.utils.Resource

interface CharacterRepository {

    fun getCharacters(): Flow<List<Character>>
    fun checkRequireNewPage(fromInit: Boolean): Flow<Resource<List<Character>>>
    fun getCharacter(characterId: Int): Flow<Character>

}
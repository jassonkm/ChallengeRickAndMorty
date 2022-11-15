package com.example.rickandmortychallenge.data.local.datasource

import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterLocalDataSource {
    fun getCharacters(): Flow<List<Character>>
    fun getCharacterByPage(page: Int): Flow<List<Character>>
    fun getCharacterFlow(characterId: Int): Flow<Character>
    suspend fun insertAll(characters: List<Character>)
    suspend fun getLastPage(): Int
    suspend fun updateCharacter(character: Character)
    suspend fun insert(character: Character)

}
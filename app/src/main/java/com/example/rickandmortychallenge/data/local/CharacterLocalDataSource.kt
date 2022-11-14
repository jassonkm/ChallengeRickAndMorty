package com.example.rickandmortychallenge.data.local

import com.example.rickandmortychallenge.data.local.dao.CharacterDao
import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.domain.model.toDomain
import com.example.rickandmortychallenge.domain.model.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject

class CharacterLocalDataSource @Inject constructor(private val characterDao: CharacterDao) {

    suspend fun insertAll(character: List<Character>){
        characterDao.insertAll(character.map { it.toRoom() })
    }

    suspend fun insert(character: Character){
        characterDao.insert(character.toRoom())
    }
    fun getCharacterByPage(page: Int): Flow<List<Character>> =
        characterDao.getCharacterByPage(page).map { characters ->
            characters.map { it.toDomain() } }
    fun getCharacters(): Flow<List<Character>> =
        characterDao.getAll().map { characters ->
            characters.map { it.toDomain() }
        }
    suspend fun getLastPage(): Int = characterDao.getLastPage()

    suspend fun updateCharacter(character: Character){
        characterDao.update(character.toRoom())
    }
}
package com.example.rickandmortychallenge.data.local

import com.example.rickandmortychallenge.data.local.dao.CharacterDao
import com.example.rickandmortychallenge.data.local.datasource.CharacterLocalDataSource
import com.example.rickandmortychallenge.di.IoDispatcher
import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.domain.model.toDomain
import com.example.rickandmortychallenge.domain.model.toRoom
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject

class CharacterLocalDataSource @Inject constructor(
    private val characterDao: CharacterDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher

):CharacterLocalDataSource {

    override suspend fun insertAll(characters: List<Character>){
        characterDao.insertAll(characters.map { it.toRoom() })
    }

    override suspend fun insert(character: Character){
        characterDao.insert(character.toRoom())
    }


    override fun getCharacterByPage(page: Int): Flow<List<Character>> =
        characterDao.getCharacterByPage(page).map { characters ->
            characters.map { it.toDomain() } }

    override fun getCharacterFlow(characterId: Int): Flow<Character> =
        characterDao.getCharacterFlow(characterId).map { it.toDomain() }


    override fun getCharacters(): Flow<List<Character>> =
        characterDao.getAll().map { characters ->
            characters.map { it.toDomain() }
        }
    override suspend fun getLastPage(): Int = characterDao.getLastPage()

    override suspend fun updateCharacter(character: Character){
        characterDao.update(character.toRoom())
    }
}
package com.example.rickandmortychallenge.data.local.datasource

import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.utils.Resource


interface CharacterRemoteDataSource {

    suspend fun getCharacters(page: Int): Resource<List<Character>>


    suspend fun getCharacterDetails(characterId: Int):Resource<Character>
}
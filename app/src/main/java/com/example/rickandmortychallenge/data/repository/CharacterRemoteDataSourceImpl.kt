package com.example.rickandmortychallenge.data.repository

import com.example.rickandmortychallenge.data.local.datasource.CharacterRemoteDataSource
import com.example.rickandmortychallenge.data.remote.api.ApiService
import com.example.rickandmortychallenge.di.IoDispatcher
import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.domain.model.toDomain
import com.example.rickandmortychallenge.utils.FailException
import com.example.rickandmortychallenge.utils.Resource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): CharacterRemoteDataSource {
    override suspend fun getCharacters(page: Int): Resource<List<Character>> = withContext(ioDispatcher){
         apiService.getCharacters(page).run {
            if (isSuccessful){
                body()?.let { body-> Resource.Success(body.results.map {  it.toDomain(page) }) } ?: Resource.Success(
                    emptyList())
            }else{
                Resource.Failure(FailException.BadRequest)
            }
        }
    }

    override suspend fun getCharacterDetails(characterId: Int): Resource<Character> = withContext(ioDispatcher){
        apiService.getCharacterDetails(characterId).run {
            if (isSuccessful){
                body()?.let { body -> Resource.Success(body.toDomain()) }?: Resource.Failure(FailException.BadRequest)
            }else{
                Resource.Failure(FailException.BadRequest)
            }
        }
    }

}
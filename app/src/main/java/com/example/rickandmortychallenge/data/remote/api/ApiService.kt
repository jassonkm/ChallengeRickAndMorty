package com.example.rickandmortychallenge.data.remote.api

import com.example.rickandmortychallenge.data.remote.model.CharacterDto
import com.example.rickandmortychallenge.data.remote.model.singleCharacter.SingleCharactersModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int):CharacterDto

    @GET("character/{character_id}")
    suspend fun getCharacterDetails(@Path("character_id") IdCharacter: Int):SingleCharactersModel

}
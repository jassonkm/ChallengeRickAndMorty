package com.example.rickandmortychallenge.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: InfoResponse,
    @SerializedName("results")
    val results: List<ResultResponse>
)

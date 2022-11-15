package com.example.rickandmortychallenge.data.remote.model

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int
)

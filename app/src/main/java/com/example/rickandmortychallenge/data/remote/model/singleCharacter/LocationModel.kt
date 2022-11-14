package com.example.rickandmortychallenge.data.remote.model.singleCharacter

import com.google.gson.annotations.SerializedName


data class LocationModel (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
    )

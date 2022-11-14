package com.example.rickandmortychallenge.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name:String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,

    @Embedded(prefix = "origin_")
    val origin: LocationEntity,

    @Embedded(prefix = "location_")
    val location: LocationEntity,
    val image: String,

    val episode: List<String>

)

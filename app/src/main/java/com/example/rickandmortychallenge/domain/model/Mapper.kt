package com.example.rickandmortychallenge.domain.model

import com.example.rickandmortychallenge.data.local.entity.CharacterEntity
import com.example.rickandmortychallenge.data.local.entity.LocationEntity
import com.example.rickandmortychallenge.data.remote.model.LocationResponse
import com.example.rickandmortychallenge.data.remote.model.ResultResponse


fun CharacterEntity.toDomain()=Character(
    id,
    name,
    status,
    type,
    species,
    gender,
    origin.toDomain(),
    location.toDomain(),
    image,
    page,
    episode
)
fun LocationEntity.toDomain()= Location(id,name)

fun Character.toRoom() = CharacterEntity(
    id,
    name,
    status,
    type,
    species,
    gender,
    origin.toRoom(),
    location.toRoom(),
    image,
    page,
    episodes
)
fun Location.toRoom() = LocationEntity(id,name)

fun ResultResponse.toDomain(page: Int? = null)= Character(
    id,
    name,
    status,
    type,
    species,
    gender,
    origin.toDomain(),
    location.toDomain(),
    image,
    page,
    episode
)
fun LocationResponse.toDomain()= Location(id,name)
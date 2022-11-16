package com.example.rickandmortychallenge.di


import com.example.rickandmortychallenge.data.repository.CharacterLocalRemoteImpl

import com.example.rickandmortychallenge.data.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CharacterModule {
    @Singleton
    @Provides
    fun provideCharacter(character: CharacterLocalRemoteImpl): CharacterRepository = character
}
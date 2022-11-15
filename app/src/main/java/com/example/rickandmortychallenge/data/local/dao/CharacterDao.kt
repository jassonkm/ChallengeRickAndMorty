package com.example.rickandmortychallenge.data.local.dao

import androidx.room.*
import com.example.rickandmortychallenge.data.local.entity.CharacterEntity

import kotlinx.coroutines.flow.Flow


@Dao
interface CharacterDao {
    @Query("SELECT * FROM characterentity")
    fun getAll(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM characterentity WHERE page = :page")
    fun getCharacterByPage(page: Int): Flow<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characterEntity: List<CharacterEntity>)

    @Query("SELECT IFNULL(MAX(page),0) FROM characterentity")
    suspend fun getLastPage(): Int

    @Query("SELECT * FROM characterentity WHERE id = :characterId")
    fun getCharacterFlow(characterId: Int): Flow<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CharacterEntity)

    @Update
    suspend fun update(character: CharacterEntity)
}

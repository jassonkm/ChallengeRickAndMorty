package com.example.rickandmortychallenge.data.repository


import com.example.rickandmortychallenge.data.local.CharacterLocalDataSource
import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class CharacterLocalRemoteImpl @Inject constructor(
    private val remote: CharacterRemoteDataSourceImpl,
    private val local: CharacterLocalDataSource
): CharacterRepository{
    override fun getCharacters(): Flow<List<Character>> =
        local.getCharacters()


    override fun checkRequireNewPage(fromInit: Boolean)= flow {
       val page = local.getLastPage()+1
        if (!fromInit || page ==1){
           emit(Resource.Loading)
            when(val character=remote.getCharacters(page)){
                is Resource.Success->{
                    local.insertAll(character.data)
                    emit(character)
                }
                else -> emit(character)
            }
        }
      }

    override fun getCharacter(characterId: Int): Flow<Character> =
        local.getCharacterFlow(characterId)
}
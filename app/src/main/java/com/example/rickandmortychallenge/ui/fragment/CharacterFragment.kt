package com.example.rickandmortychallenge.ui.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.rickandmortychallenge.R
import com.example.rickandmortychallenge.databinding.FragmentCharacterBinding
import com.example.rickandmortychallenge.ui.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import com.example.rickandmortychallenge.domain.model.Character
import kotlinx.coroutines.flow.launchIn

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val viewModel: CharacterViewModel by viewModels()
    private var binding: FragmentCharacterBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterBinding.bind(view)

        binding?.run {
            viewModel.character.onEach {
                setDetail(it)
            }.launchIn(lifecycleScope)
        }
    }
    private fun FragmentCharacterBinding.setDetail(character: Character){
        characterImg.apply {
            load(character.image)
        }
        characterNameTv.text = character.name
        characterStatusTv.text = character.status
        characterSpeciesTv.text = character.species
        characterGenderTv.text = character.gender

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
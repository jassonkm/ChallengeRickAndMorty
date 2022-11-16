package com.example.rickandmortychallenge.ui.adapter.adapterHome

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortychallenge.R
import com.example.rickandmortychallenge.databinding.ItemCharacterListBinding
import com.example.rickandmortychallenge.domain.model.Character
import com.example.rickandmortychallenge.ui.fragment.HomeFragmentDirections


class CharactersListViewHolder (private val binding: ItemCharacterListBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindTo(item: Character){
        binding.apply {
            itemCardView.setOnClickListener{
                val direction = HomeFragmentDirections.actionHomeFragmentToCharacterFragment(item.id)
                binding.root.findNavController().navigate(direction)
            }
            characterImageView.apply {
                transitionName = item.image
                load(item.image)
            }
            NameTextView.text = item.name
            when(item.status){
                "Alive" -> statusImg.setImageResource(R.drawable.ic_live)
                "Dead" -> statusImg.setImageResource(R.drawable.ic_dead)
                else -> statusImg.setImageResource(R.drawable.ic_unknown)
            }
            when (item.gender){
                "Male" -> genderImg.setImageResource(R.drawable.ic_male)
                "Female" -> genderImg.setImageResource(R.drawable.ic_female)
                else -> genderImg.setImageResource(R.drawable.ic_genderless)
            }

        }
    }
}
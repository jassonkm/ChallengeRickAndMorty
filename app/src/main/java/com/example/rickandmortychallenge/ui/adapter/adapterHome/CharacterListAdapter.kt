package com.example.rickandmortychallenge.ui.adapter.adapterHome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.rickandmortychallenge.databinding.ItemCharacterListBinding
import com.example.rickandmortychallenge.domain.model.Character


class CharacterListAdapter: ListAdapter<Character,CharactersListViewHolder>(
    diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharactersListViewHolder(ItemCharacterListBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: CharactersListViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem == newItem
        }
    }


}
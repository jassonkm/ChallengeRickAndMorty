package com.example.rickandmortychallenge.ui.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortychallenge.R
import com.example.rickandmortychallenge.databinding.FragmentHomeBinding
import com.example.rickandmortychallenge.ui.adapter.adapterHome.CharacterListAdapter
import com.example.rickandmortychallenge.ui.viewmodel.HomeViewModel
import com.example.rickandmortychallenge.utils.endless
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding?=null

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentHomeBinding.bind(view)

        val characterlistAdapter = CharacterListAdapter()

        binding?.run {
            viewModel.spinner.onEach {
            }.launchIn(lifecycleScope)

            viewModel.characters.onEach {
                characterlistAdapter.submitList(it)
            }.launchIn(lifecycleScope)

            characterListRecycler.apply {
                endless {
                    viewModel.nextPage()
                }
                adapter = characterlistAdapter
                characterlistAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

            }
        }
    }

    override fun onDestroy() {
        binding=null
        super.onDestroy()
    }



}
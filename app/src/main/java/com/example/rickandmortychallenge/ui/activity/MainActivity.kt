package com.example.rickandmortychallenge.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmortychallenge.databinding.ActivityMainBinding
import com.example.rickandmortychallenge.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }



}
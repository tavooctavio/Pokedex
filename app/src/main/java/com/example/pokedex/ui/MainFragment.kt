package com.example.pokedex.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokedex.R
import com.example.pokedex.core.Resource
import com.example.pokedex.data.remote.PokemonDataSource
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.presentation.PokemonViewModel
import com.example.pokedex.presentation.PokemonViewModelFactory
import com.example.pokedex.repository.PokemonRepositoryImpl
import com.example.pokedex.repository.RetrofitClient

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<PokemonViewModel> { PokemonViewModelFactory(PokemonRepositoryImpl(
        PokemonDataSource(RetrofitClient.webService)
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        viewModel.fetchPokemon().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading ->{
                    Log.d("LiveData", "Loading")
                }
                is Resource.Success ->{
                    Log.d("LiveData", "${result.data}")
                }
                is Resource.Failure ->{
                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }
}
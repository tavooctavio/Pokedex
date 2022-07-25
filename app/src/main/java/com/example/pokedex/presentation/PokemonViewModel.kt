package com.example.pokedex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pokedex.core.Resource
import kotlinx.coroutines.Dispatchers

class PokemonViewModel:ViewModel() {

    fun fetchPokemon() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getPokemon()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }

    }
}
package com.example.pokedex.data.remote

import com.example.pokedex.data.model.PokemonList

class PokemonDataSource {

    fun getPokemon():PokemonList{
        return PokemonList()
    }
}
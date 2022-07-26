package com.example.pokedex.data.model

data class Pokemon(
    val name: String = "",
    val url: String = ""
)

data class PokemonList(val results: List<Pokemon> = listOf())
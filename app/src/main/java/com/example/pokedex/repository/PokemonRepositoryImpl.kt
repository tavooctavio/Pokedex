package com.example.pokedex.repository

import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.data.remote.PokemonDataSource
import javax.sql.DataSource

class PokemonRepositoryImpl(private val dataSource: PokemonDataSource ) : PokemonRepository {
    override suspend fun getPokemon(): PokemonList = dataSource.getPokemon()

}
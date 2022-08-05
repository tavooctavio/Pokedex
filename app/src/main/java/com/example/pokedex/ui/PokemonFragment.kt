package com.example.pokedex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentPokemonBinding

class PokemonFragment : Fragment(R.layout.fragment_pokemon) {

    private lateinit var binding: FragmentPokemonBinding
    private val args by navArgs<PokemonFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPokemonBinding.bind(view)

        binding.tvPokemonName.text = args.namePokemon
    }
}
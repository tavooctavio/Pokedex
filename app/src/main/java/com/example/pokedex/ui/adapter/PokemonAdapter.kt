package com.example.pokedex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.core.BaseViewHolder
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.databinding.PokemonItemBinding

class PokemonAdapter:RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBiding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    private inner class PokemonViewHolder(val binding: PokemonItemBinding): BaseViewHolder<Pokemon>(binding.root){
        override fun bind(item: Pokemon) {
            binding.btnPokemonName.text = Pokemon.get(position).name
        }

    }
}
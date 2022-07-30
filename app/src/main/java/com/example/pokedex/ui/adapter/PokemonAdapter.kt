package com.example.pokedex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.core.BaseViewHolder
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonList
import com.example.pokedex.databinding.PokemonItemBinding

class PokemonAdapter(
    private val pokemonList: List<Pokemon>,
    private val itemClickListener: OnPokemonClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnPokemonClickListener {
        fun onPokemonClick(pokemon: Pokemon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBiding =
            PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = PokemonViewHolder(itemBiding)

        itemBiding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onPokemonClick(pokemonList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PokemonViewHolder -> holder.bind(pokemonList[position])
        }
    }

    override fun getItemCount(): Int = pokemonList.size

    private inner class PokemonViewHolder(val binding: PokemonItemBinding) :
        BaseViewHolder<Pokemon>(binding.root) {
        override fun bind(item: Pokemon) {
            binding.btnPokemonName.text = item.name
        }

    }
}
package com.example.kotlinpeliculas.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpeliculas.databinding.PokeItemBinding
import com.example.kotlinpeliculas.entities.Pokemon

private val TAG = PokeAdapter::class.java.simpleName


class PokeAdapter: RecyclerView.Adapter<PokeAdapter.PokeViewHolder>() {

    lateinit var onItemClickListener: (Pokemon) -> Unit

    //Atributo de la clase
    var pokemon = mutableListOf<Pokemon>()
        @SuppressLint("notifyDataSetChanged")
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeAdapter.PokeViewHolder {
        val bindingItem = PokeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return PokeViewHolder(bindingItem)
    }

    override fun onBindViewHolder(holder: PokeAdapter.PokeViewHolder, position: Int) {
        val pokemon: Pokemon = pokemon[position]
        holder.bind(pokemon)

    }

    override fun getItemCount(): Int {
        return pokemon.size

    }

    inner class PokeViewHolder(private var bindingItem: PokeItemBinding)
        : RecyclerView.ViewHolder(bindingItem.root) {

            fun bind(pokemon: Pokemon){
                with(pokemon){
                    bindingItem.txtNumPokemon.text = "#" + numId.toString()
                    bindingItem.txtNomPokemon.text = nombrePokemon
                }

                bindingItem.root.setOnClickListener {
                    if (::onItemClickListener.isInitialized){
                        onItemClickListener(pokemon)
                    }else{
                        Log.e(TAG, "Listener not initialized")
                    }
                }
            }

    }

}
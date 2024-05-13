package com.example.kotlinpeliculas

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinpeliculas.adapter.PokeAdapter
import com.example.kotlinpeliculas.databinding.ActivityMainBinding
import com.example.kotlinpeliculas.entities.Pokemon

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycleView1.layoutManager = LinearLayoutManager(this)
        initAdapter()
    }

    private fun initAdapter(){
        val pokemonAdaptador = PokeAdapter()
        binding.recycleView1.adapter = pokemonAdaptador
        pokemonAdaptador.pokemon = Pokemon.dataPokemon

        pokemonAdaptador.onItemClickListener = {
            Toast.makeText(this, "${it.nombrePokemon} es un pokémon tipo: ${it.tipoPokemon}", Toast.LENGTH_SHORT).show()


        }


    }
}
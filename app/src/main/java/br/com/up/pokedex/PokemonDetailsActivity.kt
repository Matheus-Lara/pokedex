package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.up.pokedex.network.PokeApi

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon = intent.getStringExtra("pokemon")

        PokeApi().getPokemonByName(pokemon!!){
                pokemon ->

            if(pokemon != null){

            }
        }

    }
}
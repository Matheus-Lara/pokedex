package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.up.pokedex.model.Stat
import br.com.up.pokedex.model.Type
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon = intent.getStringExtra("pokemon")
        PokeApi().getPokemonByName(pokemon!!) { pokemon ->

            if (pokemon != null) {
                val textViewName : TextView = findViewById(R.id.name_text_view)
                textViewName.text = pokemon.name

                val textViewTypes : TextView = findViewById(R.id.types_text_view)
                textViewTypes.text = "Tipos: "
                val types : List<Type> = pokemon.types

                types.forEach {
                    textViewTypes.text = textViewTypes.text as String + it.type.name + " | "
                }

                val textViewStats : TextView = findViewById(R.id.stats_text_view)
                textViewStats.text = "Stats: "
                val stats : List<Stat> = pokemon.stats

                stats.forEach {
                    textViewStats.text = textViewStats.text as String + it.stat.name + " | "
                }

                val id = pokemon.id
                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
                val imageView : ImageView = findViewById(R.id.pokemon_image)
                Picasso.get().load(url).into(imageView)
            }
        }
    }
}
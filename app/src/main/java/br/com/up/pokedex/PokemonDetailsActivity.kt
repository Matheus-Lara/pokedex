package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon = intent.getStringExtra("pokemon")
        PokeApi().getPokemonByName(pokemon!!) { pokemon ->

            if(pokemon != null){
                val id = pokemon.id;

//                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
//                val imageView : ImageView = findViewById(R.id.poke_image)
//                Picasso.get().load(url).into(imageView)
            }
        }

    }
}
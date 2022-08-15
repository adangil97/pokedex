package mx.com.sendal.jetpackcomposepokedex.pokemon.presentation.list

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color

/**
 * @author Adán Castillo.
 */
sealed class PokemonListEvent {

    data class OnSearchPokemon(
        val query: String
    ) : PokemonListEvent()

    object OnLoadPokemonPage : PokemonListEvent()

    data class CalcDominantColor(
        val drawable: Drawable,
        val onFinish: (Color) -> Unit
    ) : PokemonListEvent()
}

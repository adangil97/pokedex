package mx.com.sendal.data.pokemon.usecases

import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import mx.com.sendal.data.pokemon.repositories.PokemonRepositoryImpl

/**
 * @author Adán Castillo.
 */
class CalcDominantColorUseCase(private val pokemonRepository: PokemonRepositoryImpl) {

    operator fun invoke(drawable: Drawable, onFinish: (Color) -> Unit) =
        pokemonRepository.calcDominantColor(drawable, onFinish)
}
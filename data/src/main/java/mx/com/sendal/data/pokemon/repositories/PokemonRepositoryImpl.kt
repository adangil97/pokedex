package mx.com.sendal.data.pokemon.repositories

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import io.ktor.client.*
import mx.com.sendal.domain.pokemon.repositories.PokemonRepository

/**
 * @author Adán Castillo.
 */
class PokemonRepositoryImpl(client: HttpClient): PokemonRepository(client) {

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}
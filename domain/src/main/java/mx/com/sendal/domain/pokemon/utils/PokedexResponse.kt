package mx.com.sendal.domain.pokemon.utils

/**
 * @author Adán Castillo.
 */
sealed class PokedexResponse<T> {

    data class Success<T>(
        val content: T
    ) : PokedexResponse<T>()

    data class Failed<T>(
        val errorMessage: String,
        val errorCode: Int? = null,
        val data: T? = null
    ) : PokedexResponse<T>()
}

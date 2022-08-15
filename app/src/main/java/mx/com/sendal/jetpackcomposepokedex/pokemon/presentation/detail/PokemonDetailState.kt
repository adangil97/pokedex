package mx.com.sendal.jetpackcomposepokedex.pokemon.presentation.detail

/**
 * @author Adán Castillo.
 */
sealed class PokemonDetailState<T> {

    data class ShowLoading<T>(
        val any: Any? = null
    ) : PokemonDetailState<T>()

    data class ShowDetail<T>(
        val value: T
    ) : PokemonDetailState<T>()

    data class ShowError<T>(
        val msgError: String
    ) : PokemonDetailState<T>()
}

package mx.com.sendal.jetpackcomposepokedex.pokemon.presentation.list

import mx.com.sendal.domain.pokemon.models.list.Result
import mx.com.sendal.jetpackcomposepokedex.pokemon.models.PokemonListModel

/**
 * @author Adán Castillo.
 */

fun Result.toPokemonListModel(): PokemonListModel =
    PokemonListModel(
        name = name,
        imageUrl = imageUrl,
        number = number
    )
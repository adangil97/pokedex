package mx.com.sendal.jetpackcomposepokedex.pokemon.presentation.detail

import mx.com.sendal.domain.pokemon.models.detail.Pokemon
import mx.com.sendal.jetpackcomposepokedex.pokemon.models.PokemonModel
import mx.com.sendal.jetpackcomposepokedex.pokemon.utils.toPokemonModelType
import mx.com.sendal.jetpackcomposepokedex.pokemon.utils.toStat

/**
 * @author Adán Castillo.
 */

fun Pokemon.toPokemonModel(): PokemonModel =
    PokemonModel(
        id = id,
        name = name,
        height = height,
        weight = weight,
        types = types.map { type ->
            type.toPokemonModelType()
        },
        stats = stats.map { stat ->
            stat.toStat()
        },
        frontDefault = sprites.front_default
    )
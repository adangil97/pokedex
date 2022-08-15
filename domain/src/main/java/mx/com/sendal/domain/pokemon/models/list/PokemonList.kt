package mx.com.sendal.domain.pokemon.models.list

import kotlinx.serialization.Serializable

@Serializable
data class PokemonList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>,
    val endOfReached: Boolean = false
)
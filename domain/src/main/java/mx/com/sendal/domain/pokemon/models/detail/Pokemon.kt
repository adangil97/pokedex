package mx.com.sendal.domain.pokemon.models.detail

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val height: Int,
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)
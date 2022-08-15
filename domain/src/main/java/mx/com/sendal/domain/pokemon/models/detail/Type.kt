package mx.com.sendal.domain.pokemon.models.detail

import kotlinx.serialization.Serializable

@Serializable
data class Type(
    val slot: Int,
    val type: TypeX
)
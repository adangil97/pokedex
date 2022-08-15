package mx.com.sendal.domain.pokemon.models.detail

import kotlinx.serialization.Serializable

@Serializable
data class StatX(
    val name: String,
    val url: String
)
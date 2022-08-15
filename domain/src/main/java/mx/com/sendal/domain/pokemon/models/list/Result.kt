package mx.com.sendal.domain.pokemon.models.list

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val name: String,
    val url: String,
    val imageUrl: String = "",
    val number: Int = 0
)
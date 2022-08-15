package mx.com.sendal.domain.pokemon.models.detail

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)
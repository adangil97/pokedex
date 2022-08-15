package mx.com.sendal.jetpackcomposepokedex.pokemon.utils

import mx.com.sendal.domain.pokemon.models.detail.Stat
import mx.com.sendal.domain.pokemon.models.detail.Type
import mx.com.sendal.jetpackcomposepokedex.pokemon.models.PokemonModel
import mx.com.sendal.jetpackcomposepokedex.pokemon.models.PokemonModel.Stat.*
import mx.com.sendal.jetpackcomposepokedex.pokemon.models.PokemonModel.Type.*
import mx.com.sendal.jetpackcomposepokedex.pokemon.models.PokemonModel.Type.Unknown

fun Type.toPokemonModelType(): PokemonModel.Type {
    return when (this.type.name) {
        "normal" -> Normal
        "fire" -> Fire
        "water" -> Water
        "electric" -> Electric
        "grass" -> Grass
        "ice" -> Ice
        "fighting" -> Fighting
        "poison" -> Poison
        "ground" -> Ground
        "flying" -> Flying
        "psychic" -> Psychic
        "bug" -> Bug
        "rock" -> Rock
        "ghost" -> Ghost
        "dragon" -> Dragon
        "dark" -> Dark
        "steel" -> Steel
        "fairy" -> Fairy
        else -> Unknown
    }
}

fun Stat.toStat(): PokemonModel.Stat {
    return when (this.stat.name) {
        "hp" -> Hp(base_stat)
        "attack" -> Attack(base_stat)
        "defense" -> Defense(base_stat)
        "special-attack" -> SpecialAttack(base_stat)
        "special-defense" -> SpecialDefense(base_stat)
        "speed" -> Speed(base_stat)
        else -> None()
    }
}
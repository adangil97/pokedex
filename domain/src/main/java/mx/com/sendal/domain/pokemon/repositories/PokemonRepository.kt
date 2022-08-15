package mx.com.sendal.domain.pokemon.repositories

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import mx.com.sendal.domain.pokemon.models.detail.Pokemon
import mx.com.sendal.domain.pokemon.models.list.PokemonList
import mx.com.sendal.domain.pokemon.utils.PokedexResponse

/**
 * @author Adán Castillo.
 */
abstract class PokemonRepository(
    private val client: HttpClient
) {
    private var nextUrl: String? = null

    suspend fun getPokemonPage(): PokedexResponse<PokemonList> =
        try {
            val url = nextUrl ?: "https://pokeapi.co/api/v2/pokemon"
            val pokemonList: PokemonList = client.get(url).body()
            pokemonList.next?.let {
                nextUrl = it
            } ?: run {
                pokemonList.copy(endOfReached = true)
            }
            PokedexResponse.Success(
                pokemonList.copy(
                    results = pokemonList.results.map { result ->
                        val number = if (result.url.endsWith("/")) {
                            result.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            result.url.takeLastWhile { it.isDigit() }
                        }
                        val imageUrl =
                            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
                        result.copy(
                            name = result.name.lowercase(),
                            imageUrl = imageUrl,
                            number = number.toInt()
                        )
                    }
                )
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            println(exception.message)
            println(exception.localizedMessage)
            println(exception.cause)
            PokedexResponse.Failed(exception.message ?: "Unknown error")
        }

    suspend fun getPokemonDetail(name: String): PokedexResponse<Pokemon> =
        try {
            val url = "https://pokeapi.co/api/v2/pokemon/$name"
            val pokemon: Pokemon = client.get(url).body()
            PokedexResponse.Success(pokemon)
        } catch (exception: Exception) {
            exception.printStackTrace()
            PokedexResponse.Failed(exception.message ?: "Unknown error")
        }
}
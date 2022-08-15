package mx.com.sendal.data.pokemon.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.com.sendal.domain.pokemon.repositories.PokemonRepository

/**
 * @author Adán Castillo.
 */
class GetPokemonDetailUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(name: String) = withContext(Dispatchers.IO){
        pokemonRepository.getPokemonDetail(name)
    }
}
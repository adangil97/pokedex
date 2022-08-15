package mx.com.sendal.data.pokemon.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.com.sendal.domain.pokemon.repositories.PokemonRepository

/**
 * @author Adán Castillo.
 */
class GetPokemonPageUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke() = withContext(Dispatchers.IO){
        pokemonRepository.getPokemonPage()
    }
}
package mx.com.sendal.jetpackcomposepokedex.pokemon.presentation.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import mx.com.sendal.data.pokemon.usecases.GetPokemonDetailUseCase
import mx.com.sendal.domain.pokemon.utils.PokedexResponse
import mx.com.sendal.jetpackcomposepokedex.pokemon.models.PokemonModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    suspend fun onGetPokemonDetail(name: String): PokemonDetailState<PokemonModel> =
        when (val result = getPokemonDetailUseCase(name)) {
            is PokedexResponse.Success -> {
                PokemonDetailState.ShowDetail(
                    result.content.toPokemonModel()
                )
            }
            is PokedexResponse.Failed -> {
                PokemonDetailState.ShowError(result.errorMessage)
            }
        }
}
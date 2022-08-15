package mx.com.sendal.jetpackcomposepokedex.pokemon.presentation.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.com.sendal.data.pokemon.usecases.CalcDominantColorUseCase
import mx.com.sendal.data.pokemon.usecases.GetPokemonPageUseCase
import mx.com.sendal.domain.pokemon.utils.PokedexResponse
import mx.com.sendal.jetpackcomposepokedex.pokemon.models.PokemonListModel
import javax.inject.Inject

/**
 * @author Adán Castillo.
 */
@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonPageUseCase: GetPokemonPageUseCase,
    private val calcDominantColorUseCase: CalcDominantColorUseCase
) : ViewModel() {

    var pokemonList = mutableStateOf<List<PokemonListModel>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    private var cachedPokemonList = listOf<PokemonListModel>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)

    init {
        loadPokemonPage()
    }

    fun onEvent(event: PokemonListEvent) {
        when (event) {
            is PokemonListEvent.CalcDominantColor -> calcDominantColorUseCase(
                event.drawable,
                event.onFinish
            )
            PokemonListEvent.OnLoadPokemonPage -> loadPokemonPage()
            is PokemonListEvent.OnSearchPokemon -> searchPokemonList(event.query)
        }
    }

    fun searchPokemonList(query: String) {
        val listToSearch = if (isSearchStarting) {
            pokemonList.value
        } else {
            cachedPokemonList
        }
        viewModelScope.launch {
            if (query.isEmpty()) {
                pokemonList.value = cachedPokemonList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.name.contains(query.trim(), ignoreCase = true) ||
                        it.number.toString() == query.trim()
            }
            if (isSearchStarting) {
                cachedPokemonList = pokemonList.value
                isSearchStarting = false
            }
            pokemonList.value = results
            isSearching.value = true
        }
    }

    fun loadPokemonPage() {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = getPokemonPageUseCase()) {
                is PokedexResponse.Failed -> {
                    loadError.value = result.errorMessage
                    isLoading.value = false
                }
                is PokedexResponse.Success -> {
                    endReached.value = result.content.endOfReached
                    val pokemonListModel = result.content.results.map {
                        it.toPokemonListModel()
                    }

                    loadError.value = ""
                    isLoading.value = false
                    pokemonList.value += pokemonListModel
                }
            }
        }
    }
}
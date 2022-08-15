package mx.com.sendal.jetpackcomposepokedex.pokemon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.ktor.client.*
import mx.com.sendal.data.pokemon.repositories.PokemonRepositoryImpl
import mx.com.sendal.data.pokemon.usecases.CalcDominantColorUseCase
import mx.com.sendal.data.pokemon.usecases.GetPokemonDetailUseCase
import mx.com.sendal.data.pokemon.usecases.GetPokemonPageUseCase
import mx.com.sendal.domain.pokemon.repositories.PokemonRepository

/**
 * @author Adán Castillo.
 */
@Module
@InstallIn(ViewModelComponent::class)
object PokemonModule {

    @Provides
    @ViewModelScoped
    fun providesPokemonRepository(client: HttpClient): PokemonRepository =
        PokemonRepositoryImpl(client)

    @Provides
    @ViewModelScoped
    fun providesGetPokemonPageUseCase(pokemonRepository: PokemonRepository): GetPokemonPageUseCase =
        GetPokemonPageUseCase(pokemonRepository)

    @Provides
    @ViewModelScoped
    fun providesGetPokemonDetailUseCase(pokemonRepository: PokemonRepository): GetPokemonDetailUseCase =
        GetPokemonDetailUseCase(pokemonRepository)

    @Provides
    @ViewModelScoped
    fun providesCalcDominantColorUseCase(pokemonRepository: PokemonRepository): CalcDominantColorUseCase =
        CalcDominantColorUseCase(pokemonRepository as PokemonRepositoryImpl)
}
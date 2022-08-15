package mx.com.sendal.jetpackcomposepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import mx.com.sendal.jetpackcomposepokedex.pokemon.presentation.detail.PokemonDetailScreen
import mx.com.sendal.jetpackcomposepokedex.pokemon.presentation.list.PokemonListScreen
import mx.com.sendal.jetpackcomposepokedex.ui.theme.JetpackComposePokedexTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePokedexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "pokemon_list_screen"
                ) {
                    composable("pokemon_list_screen") {
                        PokemonListScreen(navController = navController)
                    }
                    composable(
                        "pokemon_detail_screen/{color}/{name}",
                        arguments = listOf(
                            navArgument("color") {
                                type = NavType.IntType
                            },
                            navArgument("name") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val color = remember {
                            val color = it.arguments?.getInt("color")
                            Color(requireNotNull(color))
                        }
                        val name = remember {
                            val name = it.arguments?.getString("name")
                            requireNotNull(name)
                        }
                        PokemonDetailScreen(
                            dominantColor = color,
                            pokemonName = name.lowercase(),
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
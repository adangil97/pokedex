package mx.com.sendal.jetpackcomposepokedex.pokemon.models

import androidx.compose.ui.graphics.Color
import mx.com.sendal.jetpackcomposepokedex.ui.theme.AtkColor
import mx.com.sendal.jetpackcomposepokedex.ui.theme.DefColor
import mx.com.sendal.jetpackcomposepokedex.ui.theme.HPColor
import mx.com.sendal.jetpackcomposepokedex.ui.theme.SpAtkColor
import mx.com.sendal.jetpackcomposepokedex.ui.theme.SpDefColor
import mx.com.sendal.jetpackcomposepokedex.ui.theme.SpdColor
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeBug
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeDark
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeDragon
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeElectric
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeFairy
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeFighting
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeFire
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeFlying
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeGhost
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeGrass
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeGround
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeIce
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeNormal
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypePoison
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypePsychic
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeRock
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeSteel
import mx.com.sendal.jetpackcomposepokedex.ui.theme.TypeWater

/**
 * @author Adán Castillo.
 */
data class PokemonModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Type>,
    val stats: List<Stat>,
    val frontDefault: String
) {
    enum class Type(val color: Color) {
        Normal(TypeNormal),
        Fire(TypeFire),
        Water(TypeWater),
        Electric(TypeElectric),
        Grass(TypeGrass),
        Ice(TypeIce),
        Fighting(TypeFighting),
        Poison(TypePoison),
        Ground(TypeGround),
        Flying(TypeFlying),
        Psychic(TypePsychic),
        Bug(TypeBug),
        Rock(TypeRock),
        Ghost(TypeGhost),
        Dragon(TypeDragon),
        Dark(TypeDark),
        Steel(TypeSteel),
        Fairy(TypeFairy),
        Unknown(Color.Black)
    }

    sealed class Stat(
        open val base: Int,
        open val name: String,
        open val color: Color
    ) {

        data class Hp(
            override val base: Int,
            override val name: String = "HP",
            override val color: Color = HPColor
        ) : Stat(base, name, color)

        data class Attack(
            override val base: Int,
            override val name: String = "Atk",
            override val color: Color = AtkColor
        ) : Stat(base, name, color)

        data class Defense(
            override val base: Int,
            override val name: String = "Def",
            override val color: Color = DefColor
        ) : Stat(base, name, color)

        data class SpecialAttack(
            override val base: Int,
            override val name: String = "SpAtk",
            override val color: Color = SpAtkColor
        ) : Stat(base, name, color)

        data class SpecialDefense(
            override val base: Int,
            override val name: String = "SpDef",
            override val color: Color = SpDefColor
        ) : Stat(base, name, color)

        data class Speed(
            override val base: Int,
            override val name: String = "Spd",
            override val color: Color = SpdColor
        ) : Stat(base, name, color)

        data class None(
            override val base: Int = 0,
            override val name: String = "",
            override val color: Color = Color.White
        ) : Stat(base, name, color)
    }
}
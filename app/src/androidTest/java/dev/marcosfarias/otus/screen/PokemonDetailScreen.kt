package dev.marcosfarias.otus.screen

import com.kaspersky.kaspresso.screens.KScreen
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.ui.dashboard.DashboardFragment
import io.github.kakaocup.kakao.text.KTextView


object PokemonDetailScreen : KScreen<PokemonDetailScreen>() {

    override val layoutId: Int? = R.layout.fragment_dashboard
    override val viewClass: Class<*>? = DashboardFragment::class.java

    val name = KTextView { withId(R.id.textViewName) }
    val id = KTextView { withId(R.id.textViewID) }


}
package dev.marcosfarias.otus.screen

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.ui.pokedex.PokedexFragment
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object PokedexScreen : KScreen<PokedexScreen>() {
    override val layoutId: Int? = R.layout.fragment_pokedex
    override val viewClass: Class<*>? = PokedexFragment::class.java

    val pokedexRv = KRecyclerView(
        builder = {
            withId(R.id.recyclerView)
        },
        itemTypeBuilder = {
            itemType(::PokedexItem)
        }
    )

    internal class PokedexItem(parent: Matcher<View>) : KRecyclerItem<PokedexItem>(parent) {
        val name = KTextView(parent) {
            withId(R.id.textViewName)
        }
        val id = KTextView(parent) {
            withId(R.id.textViewID)
        }
    }
}
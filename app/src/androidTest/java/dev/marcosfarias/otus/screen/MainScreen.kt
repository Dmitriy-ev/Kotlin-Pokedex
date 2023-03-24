package dev.marcosfarias.otus.screen

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import dev.marcosfarias.pokedex.MainActivity
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.ui.home.HomeFragment
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

class MainScreen: KScreen<MainScreen>() {
    override val layoutId: Int? = R.layout.fragment_home
    override val viewClass: Class<*>? = HomeFragment::class.java

    val menuRv = KRecyclerView({
        withId(R.id.recyclerViewMenu)},
        itemTypeBuilder = {
            itemType(::MenuItem)
        })

    internal class MenuItem(parent: Matcher<View>) : KRecyclerItem<MenuItem>(parent) {
        val description = KTextView(parent) {
            withId(R.id.textViewName)
        }

        val image = KImageView {
            withId(R.id.icon)
        }
    }
}
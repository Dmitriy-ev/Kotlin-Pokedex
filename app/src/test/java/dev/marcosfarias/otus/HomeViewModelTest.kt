package dev.marcosfarias.otus

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.model.Menu
import dev.marcosfarias.pokedex.ui.home.HomeViewModel
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.rules.TestRule

class HomeViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var homeViewModel: HomeViewModel

    @Before
    fun before() {
        homeViewModel = HomeViewModel()
    }

    @Test
    fun getListMenu() {
        val expectedData = listOf(
            Menu(id = 1, name = R.string.menu_item_1, color = R.color.lightTeal),
            Menu(id = 1, name = R.string.menu_item_2, color = R.color.lightRed),
            Menu(id = 1, name = R.string.menu_item_3, color = R.color.lightBlue),
            Menu(id = 1, name = R.string.menu_item_4, color = R.color.lightYellow),
            Menu(id = 1, name = R.string.menu_item_5, color = R.color.lightPurple),
            Menu(id = 1, name = R.string.menu_item_6, color = R.color.lightBrown)
        )

        assertEquals(
            expectedData.map { it.toString() },
            homeViewModel.getListMenu().value?.map { it.toString() })
    }

    @Test
    fun getListNews() {

        val expectedData = 8

        assertEquals(expectedData, homeViewModel.getListNews().value?.size)
    }

}
package dev.marcosfarias.otus

import androidx.lifecycle.MutableLiveData
import dev.marcosfarias.pokedex.database.dao.PokemonDAO
import dev.marcosfarias.pokedex.model.Pokemon
import dev.marcosfarias.pokedex.repository.PokemonService
import dev.marcosfarias.pokedex.ui.pokedex.PokedexViewModel
import io.mockk.every
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest


class PokedexViewModelTest: KoinTest {

    val pokemonDAO = mockk<PokemonDAO>(relaxed = true)
    val pokemonService = mockk<PokemonService>(relaxed = true)
    lateinit var pokedexViewModel: PokedexViewModel

    @get:Rule
    var rule = MockKRule(true)

    @Before
    fun before() {
        pokedexViewModel = PokedexViewModel(pokemonDAO, pokemonService)
    }

    @Test
    fun getListPokemon() {

        val expectedData = listOf(
            Pokemon(name = "Bulbasaur"),
            Pokemon(name = "Pokemon")
        )
        every {pokemonDAO.all()} returns MutableLiveData(expectedData)

        val actual = pokedexViewModel.getListPokemon()

        assertEquals(expectedData, actual.value)

    }
}
package dev.marcosfarias.otus

import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.database.AppDatabase
import dev.marcosfarias.pokedex.database.dao.PokemonDAO
import dev.marcosfarias.pokedex.model.Pokemon
import io.mockk.every
import io.mockk.junit4.MockKRule
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class AppDatabaseTest {

    @get:Rule
    var rule = MockKRule(true)

    val pokemonDAO: PokemonDAO = mockk()

    private val pokemon1 = Pokemon(id = "001", name = "pokemon1")
    private val pokemon2 = Pokemon(id = "002", name = "pokemon2")
    private val pokemon3 = Pokemon(id = "003", name = "pokemon3")
    private val pokemon4 = Pokemon(id = "004", name = "pokemon4")
    private val pokemon5 = Pokemon(id = "005", name = "pokemon5")
    private val pokemon6 = Pokemon(id = "006", name = "pokemon6")

    private val listPokemon = listOf(
       pokemon1,
       pokemon2,
       pokemon3,
       pokemon4,
       pokemon5,
       pokemon6
    )

    @Test
    fun getById() {

        val expectedMessage = Pokemon(
            id = "001"
        )

        every { pokemonDAO.getById("001") } returns MutableLiveData(expectedMessage)

        val result = pokemonDAO.getById(expectedMessage.id)

        assertEquals(expectedMessage.id, result.value?.id)
    }

    @Test
    fun getEvolutionsByIds() {
        val expectedEvolutionIds = listOf("001", "0012")

        val pokemonList = MutableLiveData(listPokemon)

        every { pokemonDAO.getEvolutionsByIds(expectedEvolutionIds) } returns pokemonList

        val result = pokemonDAO.getEvolutionsByIds(expectedEvolutionIds)
        assertEquals(listPokemon, result.value)
    }

    @Test
    fun getAll(){

        every { pokemonDAO.all() } returns MutableLiveData(listPokemon)

        val result = pokemonDAO.all()

        assertEquals(listPokemon, result.value)

    }
}
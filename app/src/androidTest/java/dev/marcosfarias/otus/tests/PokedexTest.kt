package dev.marcosfarias.otus.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import dev.marcosfarias.otus.BaseTest
import dev.marcosfarias.otus.screen.MainScreen
import dev.marcosfarias.otus.screen.PokedexScreen
import dev.marcosfarias.pokedex.MainActivity
import dev.marcosfarias.pokedex.model.Pokemon
import org.junit.Rule
import org.junit.Test


class PokedexTest : BaseTest() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun pokemonListIsDisplayed() {
        run {
            step("pokemon list is displayed") {
                MainScreen {
                    menuRv {
                        firstChild<MainScreen.MenuItem> {
                            click()
                        }
                    }
                }
                PokedexScreen {
                    pokedexRv {
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun verifyPokemonDataIsDisplayed() {
        val pokemon = Pokemon(
            id = "#001",
            name = "Bulbasaur"
        )
        run {
            step("pokemon data is displayed") {
                MainScreen {
                    menuRv {
                        firstChild<MainScreen.MenuItem> {
                            click()
                        }
                    }
                }
                PokedexScreen {
                    pokedexRv {
                        firstChild<PokedexScreen.PokedexItem> {
                            name {
                                isDisplayed()
                                hasText(pokemon.name?: "null")
                            }
                            id {
                                hasText(pokemon.id)
                            }
                        }
                    }
                }
            }
        }
    }
}



package dev.marcosfarias.otus.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.marcosfarias.otus.BaseTest
import dev.marcosfarias.otus.screen.MainScreen
import dev.marcosfarias.pokedex.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainTest : BaseTest() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifySearchBarTextIsDisplayed(){
        run {
            step("verify search bar text is displayed"){
                MainScreen{
                    searchTv{
                        isDisplayed()
                        hasText("Search Pokemon, Move, Ability")//, etc
                    }
                }
            }
        }
    }

    @Test
    fun verifyMenuIsDisplayed(){
        run{
            step("verify menu is displayed"){
                MainScreen{
                    menuRv{
                        isDisplayed()
                    }
                }
            }
        }
    }

    @Test
    fun checkSizeMenuList(){
        run{
            step("check size menu list"){
                MainScreen{
                    menuRv{
                        hasSize(6)
                    }
                }
            }
        }
    }

    @Test
    fun shouldRenderTitleMenu(){
        val expectedMessage = listOf("Pokedex", "Moves", "Abilities", "Items", "Locations", "Type Charts")
        run{
            step("should render title menu"){
                MainScreen{
                    menuRv{
                        for (i in 0..5){
                            childAt<MainScreen.MenuItem>(i){
                                description.hasText(expectedMessage[i])
                            }
                        }
                    }
                }
            }
        }
    }
}
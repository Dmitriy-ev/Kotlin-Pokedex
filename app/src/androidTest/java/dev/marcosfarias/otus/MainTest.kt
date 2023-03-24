package dev.marcosfarias.otus

import android.content.res.Resources
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.action.ViewActions
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import dev.marcosfarias.otus.screen.MainScreen
import dev.marcosfarias.pokedex.MainActivity
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.robots.BaseRobot
import dev.marcosfarias.pokedex.ui.home.HomeFragment
import io.github.kakaocup.kakao.screen.Screen
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class MainTest : BaseTest() {


    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkMenu() {
        run {
            Screen.onScreen<MainScreen> {
                menuRv {
                    firstChild<MainScreen.MenuItem> {
                        description {
                            hasText("Pokedex")
                        }
                    }
                }
            }
        }
    }
}
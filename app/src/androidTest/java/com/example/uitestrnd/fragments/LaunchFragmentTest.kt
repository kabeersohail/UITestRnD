package com.example.uitestrnd.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitestrnd.R
import com.example.uitestrnd.UITestApplication
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LaunchFragmentTest {

    private val uiTestApplication: UITestApplication = ApplicationProvider.getApplicationContext()

    @Test
    fun isLaunchFragmentVisible() {

        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())

        val scenario = launchFragmentInContainer<LaunchFragment>()

        scenario.onFragment { launchFragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(launchFragment.requireView(), navController)
        }

        onView(ViewMatchers.withId(R.id.launch_fragment))
            .check(matches(isDisplayed()))

    }

    @Test
    fun isTextEqualToLaunchFragment() {
        val scenario = launchFragmentInContainer<LaunchFragment>()

        onView(ViewMatchers.withId(R.id.launch_fragment_text)).check(matches(withText(R.string.launch_fragment)))
    }

    @Test
    fun checkIfVariableValueIsSohail() = runTest {
        val scenario = launchFragmentInContainer<LaunchFragment>()

        scenario.onFragment { launchFragment ->
            Assert.assertEquals("SOHAIL", launchFragment.testerName)
        }

    }

    @Test
    fun verifyIf() = runTest {
        Assert.assertEquals("Sohail", uiTestApplication.testerName)
    }

}
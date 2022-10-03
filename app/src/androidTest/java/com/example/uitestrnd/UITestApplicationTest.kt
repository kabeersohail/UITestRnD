package com.example.uitestrnd

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITestApplicationTest {



    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testIfColdFlowIsInitialised() = runTest {

        val uiTestApplication = InstrumentationRegistry.getInstrumentation().targetContext as UITestApplication

        Assert.assertEquals("SOHAIL", uiTestApplication.x)
    }

}
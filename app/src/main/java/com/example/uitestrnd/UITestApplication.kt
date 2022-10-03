package com.example.uitestrnd

import android.app.Application
import androidx.annotation.VisibleForTesting
import com.example.uitestrnd.commandscheduler.CommandScheduler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class UITestApplication: Application() {
//
//    @VisibleForTesting
//    internal val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    lateinit var x: String

    @VisibleForTesting
    internal var testerName: String = "Sohail"

    override fun onCreate() {
        super.onCreate()
//        applicationScope.launch { initializeColdFlow() }

        init()

    }

    @VisibleForTesting
    internal fun init() {
        x = "SOHAIL"
    }

    @VisibleForTesting
    internal suspend fun initializeColdFlow() {
//        CommandScheduler.adminCommandCollector()
//        testerName = "YES"
    }

}
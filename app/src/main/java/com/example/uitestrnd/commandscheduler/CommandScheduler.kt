package com.example.uitestrnd.commandscheduler

import com.example.uitestrnd.interfaces.SingleListener
import com.example.uitestrnd.models.AdminCommand
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

object CommandScheduler {

    lateinit var singleListener: SingleListener

    private val adminCommandFlow: Flow<AdminCommand> = callbackFlow {

        singleListener = object: SingleListener {
            override suspend fun onMessageReceived(adminCommand: AdminCommand) {
                send(adminCommand)
            }

            override suspend fun onDataChange(adminCommand: AdminCommand) {
                send(adminCommand)
            }

            override suspend fun manualEvent(adminCommand: AdminCommand) {
                send(adminCommand)
            }
        }
        awaitClose()
    }

    suspend fun adminCommandCollector() {
        adminCommandFlow.collect {
            println(it)
        }
    }

}
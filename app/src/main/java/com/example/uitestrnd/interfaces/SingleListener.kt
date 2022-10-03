package com.example.uitestrnd.interfaces

import com.example.uitestrnd.models.AdminCommand

interface SingleListener {
    suspend fun onMessageReceived(adminCommand: AdminCommand)
    suspend fun onDataChange(adminCommand: AdminCommand)
    suspend fun manualEvent(adminCommand: AdminCommand)
}
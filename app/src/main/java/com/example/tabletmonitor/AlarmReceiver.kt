package com.example.tabletmonitor

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.tabletmonitor.utils.NotificationHelper

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val name = intent.getStringExtra("tablet_name")
        NotificationHelper(context).showNotification(
            "Tablet Reminder",
            "Time to take your $name"
        )
    }
}
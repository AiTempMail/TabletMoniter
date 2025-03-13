package com.example.tabletmonitor.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.tabletmonitor.MainActivity
import com.example.tabletmonitor.R
import java.util.Random

class NotificationHelper(private val context: Context) {

    companion object {
        private const val POST_NOTIFICATIONS_PERMISSION = android.Manifest.permission.POST_NOTIFICATIONS
    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "tablet_channel",
                "Tablet Reminders",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Time to take your tablets"
            }

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun showNotification(title: String, message: String) {
        // Check if the app has the POST_NOTIFICATIONS permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    POST_NOTIFICATIONS_PERMISSION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Permission not granted, handle accordingly
                return
            }
        }

        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, "tablet_channel")
            .setSmallIcon(R.drawable.ic_pill)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        try {
            NotificationManagerCompat.from(context).notify(Random().nextInt(), notification)
        } catch (e: SecurityException) {
            // Handle the SecurityException (e.g., log the error or show a message)
            e.printStackTrace()
        }
    }
}
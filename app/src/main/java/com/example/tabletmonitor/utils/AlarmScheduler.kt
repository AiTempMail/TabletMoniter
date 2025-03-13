package com.example.tabletmonitor.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.tabletmonitor.AlarmReceiver
import com.example.tabletmonitor.database.Tablet
import java.util.Calendar

class AlarmScheduler(private val context: Context) {

    @RequiresApi(Build.VERSION_CODES.S)
    fun scheduleAlarm(tablet: Tablet) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // Check if the app can schedule exact alarms
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && !alarmManager.canScheduleExactAlarms()) {
            // Handle the case where exact alarms cannot be scheduled
            return
        }

        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("tablet_name", tablet.name)
            putExtra("tablet_id", tablet.id)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            tablet.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, tablet.schedule.split(":")[0].toInt())
            set(Calendar.MINUTE, tablet.schedule.split(":")[1].toInt())
        }

        try {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        } catch (e: SecurityException) {
            // Handle the SecurityException
            e.printStackTrace()
        }
    }
}
package com.example.tabletmonitor.utils

import android.content.Context
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import timber.log.Timber

object Logger {
    private const val LOG_FILE = "app_logs.txt"

    fun log(message: String, context: Context) {
        Timber.d(message)
        writeToFile(message, context)
    }

    private fun writeToFile(message: String, context: Context) {
        try {
            val logFile = File(context.getExternalFilesDir(null), LOG_FILE)
            logFile.appendText("${SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())}: $message\n")
        } catch (e: Exception) {
            Timber.e("Error writing to log file: ${e.message}")
        }
    }
}
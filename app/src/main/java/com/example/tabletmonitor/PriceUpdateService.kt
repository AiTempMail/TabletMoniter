package com.example.tabletmonitor

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.tabletmonitor.api.RetrofitClient
import com.example.tabletmonitor.database.Tablet
import com.example.tabletmonitor.database.TabletDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PriceUpdateService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        updatePrices()
        return START_NOT_STICKY
    }

    private fun updatePrices() {
        CoroutineScope(Dispatchers.IO).launch {
            val dao = TabletDatabase.getDatabase(applicationContext).tabletDao()
            val tablets = dao.getAllTablets().first() // Collect the first emission from Flow
            tablets.forEach { tablet ->
                val response = RetrofitClient.instance.getPriceHistory(tablet.name)
                if (response.isSuccessful) {
                    val updatedTablet = tablet.copy(priceHistory = response.body()?.prices ?: emptyList())
                    withContext(Dispatchers.IO) {
                        dao.update(updatedTablet)
                    }
                }
            }
        }
    }
}
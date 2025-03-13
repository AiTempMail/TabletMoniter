package com.example.tabletmonitor

import android.app.Application
import com.example.tabletmonitor.database.TabletDatabase

class TabletMonitorApp : Application() {

    val database: TabletDatabase by lazy {
        TabletDatabase.getDatabase(this)
    }
}
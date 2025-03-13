package com.example.tabletmonitor.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context

@Database(entities = [Tablet::class], version = 1)
@TypeConverters(Converters::class)
abstract class TabletDatabase : RoomDatabase() {

    abstract fun tabletDao(): TabletDao

    companion object {
        @Volatile
        private var INSTANCE: TabletDatabase? = null

        fun getDatabase(context: Context): TabletDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TabletDatabase::class.java,
                    "tablet_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
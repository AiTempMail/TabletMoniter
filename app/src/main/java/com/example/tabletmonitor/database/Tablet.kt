package com.example.tabletmonitor.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date
import java.util.UUID

@Entity(tableName = "tablets")
@TypeConverters(Converters::class)
data class Tablet(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val dosage: String,
    val schedule: String,
    val stock: Int,
    val lastRefill: Date, // Room will use the TypeConverter for this field
    val priceHistory: List<Float>, // Room will use the TypeConverter for this field
    val description: String = ""
)
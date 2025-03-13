package com.example.tabletmonitor.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

class Converters {

    // Convert Date to Long (timestamp)
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }

    // Convert Long (timestamp) to Date
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    // Convert List<Float> to JSON String
    @TypeConverter
    fun fromPriceHistory(priceHistory: List<Float>?): String? {
        return Gson().toJson(priceHistory)
    }

    // Convert JSON String to List<Float>
    @TypeConverter
    fun toPriceHistory(json: String?): List<Float>? {
        return json?.let {
            Gson().fromJson(it, object : TypeToken<List<Float>>() {}.type)
        }
    }
}
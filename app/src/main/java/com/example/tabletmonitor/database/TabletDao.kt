package com.example.tabletmonitor.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TabletDao {
    @Query("SELECT * FROM tablets")
    fun getAllTablets(): Flow<List<Tablet>>

    @Insert
    suspend fun insert(tablet: Tablet)

    @Update
    suspend fun update(tablet: Tablet)

    @Query("DELETE FROM tablets WHERE id = :id")
    suspend fun delete(id: String)
}
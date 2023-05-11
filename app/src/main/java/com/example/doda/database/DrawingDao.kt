package com.example.doda.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.doda.models.Drawing
import com.example.doda.models.Marker

@Dao
interface DrawingDao {
    @Query("SELECT * FROM drawing_table ORDER BY addition_time DESC")
    fun getAllDrawings(): LiveData<List<Drawing>>

    @Insert
    suspend fun insert(drawing: Drawing): Long

    @Update
    suspend fun update(drawing: Drawing)

    @Delete
    suspend fun delete(drawing: Drawing)
}

@Dao
interface MarkerDao {
    @Query("SELECT * FROM marker_table WHERE drawing_id = :drawingId")
    fun getMarkersByDrawingId(drawingId: Int): LiveData<List<Marker>>

    @Insert
    suspend fun insert(marker: Marker): Long

    @Update
    suspend fun update(marker: Marker)

    @Delete
    suspend fun delete(marker: Marker)
}

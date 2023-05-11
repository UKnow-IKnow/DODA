package com.example.doda.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.doda.models.Drawing
import com.example.doda.models.Marker

@Database(entities = [Drawing::class, Marker::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun drawingDao(): DrawingDao
    abstract fun markerDao(): MarkerDao
}
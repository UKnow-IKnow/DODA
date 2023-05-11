package com.example.doda.repository

import androidx.lifecycle.LiveData
import com.example.doda.database.MarkerDao
import com.example.doda.models.Marker

class MarkerRepository(private val markerDao: MarkerDao) {
    fun getMarkersByDrawingId(drawingId: Int): LiveData<List<Marker>> {
        return markerDao.getMarkersByDrawingId(drawingId)
    }

    suspend fun insert(marker: Marker) {
        markerDao.insert(marker)
    }
}
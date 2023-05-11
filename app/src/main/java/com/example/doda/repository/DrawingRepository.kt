package com.example.doda.repository

import androidx.lifecycle.LiveData
import com.example.doda.database.DrawingDao
import com.example.doda.models.Drawing

class DrawingRepository(private val drawingDao: DrawingDao) {
    val allDrawings: LiveData<List<Drawing>> = drawingDao.getAllDrawings()

    suspend fun insert(drawing: Drawing) {
        drawingDao.insert(drawing)
    }
}
package com.example.doda.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doda.models.Marker
import com.example.doda.repository.MarkerRepository
import kotlinx.coroutines.launch

class MarkerViewModel(private val repository: MarkerRepository) : ViewModel() {
    lateinit var allMarkers: LiveData<List<Marker>>

    fun setDrawingId(drawingId: Int) {
        allMarkers = repository.getMarkersByDrawingId(drawingId)
    }

    fun insert(marker: Marker) = viewModelScope.launch {
        repository.insert(marker)
    }
}
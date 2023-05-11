package com.example.doda.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doda.models.Drawing
import com.example.doda.repository.DrawingRepository
import kotlinx.coroutines.launch

class DrawingViewModel(private val repository: DrawingRepository) : ViewModel() {
    val allDrawings: LiveData<List<Drawing>> = repository.allDrawings

    fun insert(drawing: Drawing) = viewModelScope.launch {
        repository.insert(drawing)
    }
}
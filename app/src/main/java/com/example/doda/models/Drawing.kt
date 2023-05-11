package com.example.doda.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drawing_table")
data class Drawing(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val additionTime: Long?,
    val thumbnail: String?,
    val name: String
)

@Entity(tableName = "marker_table")
data class Marker (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val drawingId: Int,
    val markerTitle: String,
    val markerDetails: String
)

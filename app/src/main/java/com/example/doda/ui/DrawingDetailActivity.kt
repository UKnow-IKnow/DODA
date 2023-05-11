package com.example.doda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doda.R
import com.example.doda.adapters.MarkerAdapter
import com.example.doda.viewModels.MarkerViewModel

class DrawingDetailActivity : AppCompatActivity() {

    private lateinit var markerViewModel: MarkerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing_detail)

        val drawingId = intent.getIntExtra("drawingId", 0)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_markers)
        val adapter = MarkerAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        markerViewModel = ViewModelProvider(this).get(MarkerViewModel::class.java)
        markerViewModel.setDrawingId(drawingId)
        markerViewModel.allMarkers.observe(this, Observer { markers ->
            markers?.let { adapter.setMarkers(it) }
        })
    }
}

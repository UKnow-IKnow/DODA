package com.example.doda.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doda.R
import com.example.doda.adapters.DrawingAdapter
import com.example.doda.models.Drawing
import com.example.doda.repository.DrawingRepository
import com.example.doda.viewModels.DrawingViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var drawingViewModel: DrawingViewModel
    val viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
    private val newDrawingActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = DrawingAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val drawingViewModel = ViewModelProvider(this, viewModelFactory).get(DrawingViewModel::class.java)

        drawingViewModel.allDrawings.observe(this, Observer { drawings ->
            // Update the cached copy of the drawings in the adapter.
            drawings?.let { adapter.setDrawings(it) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.add_drawing_fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewDrawingActivity::class.java)
            startActivityForResult(intent, newDrawingActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newDrawingActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewDrawingActivity.EXTRA_REPLY)?.let { drawingName ->
                if (drawingName.isNotEmpty()) {
                    val drawing = Drawing(name = drawingName, additionTime = null, id = null, thumbnail = null)

                    drawingViewModel.insert(drawing)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "not saved",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        } else {
            Toast.makeText(
                applicationContext,
                "not saved",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}

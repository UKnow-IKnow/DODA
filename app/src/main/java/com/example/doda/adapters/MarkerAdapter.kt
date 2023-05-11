package com.example.doda.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doda.R
import com.example.doda.models.Marker

class MarkerViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.marker_title)
    val details: TextView = view.findViewById(R.id.marker_details)
}

class MarkerAdapter(private val context: Context): RecyclerView.Adapter<MarkerViewHolder>() {

    private var markers = emptyList<Marker>() // Cached copy of markers

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkerViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.marker_item, parent, false)
        return MarkerViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarkerViewHolder, position: Int) {
        val current = markers[position]
        holder.title.text = current.markerTitle
        holder.details.text = current.markerDetails
    }

    internal fun setMarkers(markers: List<Marker>) {
        this.markers = markers
        notifyDataSetChanged()
    }

    override fun getItemCount() = markers.size
}

package com.example.doda.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doda.ui.DrawingDetailActivity
import com.example.doda.R
import com.example.doda.models.Drawing
import java.text.DateFormat
import java.util.*

class DrawingAdapter(private val context: Context) : RecyclerView.Adapter<DrawingAdapter.DrawingViewHolder>() {

    private var drawings = emptyList<Drawing>() // Cached copy of drawings

    class DrawingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrawingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return DrawingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DrawingViewHolder, position: Int) {
        val current = drawings[position]
        holder.textViewName.text = current.drawingName
        holder.textViewDate.text = DateFormat.getDateTimeInstance().format(Date(current.additionTime))

        // On item click, open DrawingDetailActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DrawingDetailActivity::class.java).apply {
                putExtra("drawingId", current.id)
            }
            context.startActivity(intent)
        }
    }

    internal fun setDrawings(drawings: List<Drawing>) {
        this.drawings = drawings
        notifyDataSetChanged()
    }

    override fun getItemCount() = drawings.size
}

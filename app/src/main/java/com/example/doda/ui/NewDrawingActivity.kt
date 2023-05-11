package com.example.doda.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.doda.R

class NewDrawingActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_REPLY = "com.example.android.drawinglistsql.REPLY"
    }

    private lateinit var editDrawingView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_drawing)
        editDrawingView = findViewById(R.id.edit_drawing)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editDrawingView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val drawing = editDrawingView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, drawing)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }
}

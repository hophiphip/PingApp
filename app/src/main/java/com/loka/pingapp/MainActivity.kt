package com.loka.pingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.loka.pingapp.utils.Ip

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTextContents()
    }

    private fun setTextContents() {
        val mainTextView: TextView = findViewById(R.id.main_text_view_id)
        mainTextView.text = Ip.address() ?: "None"
    }
}
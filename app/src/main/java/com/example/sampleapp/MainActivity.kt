package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButton = findViewById<Button>(R.id.clickButton)
        val countText = findViewById<TextView>(R.id.countText)

        clickButton.setOnClickListener {
            clickCount++
            countText.text = resources.getQuantityString(R.plurals.click_count, clickCount, clickCount)

            if (clickCount % 5 == 0) {
                Toast.makeText(this, resources.getQuantityString(R.plurals.click_toast, clickCount, clickCount), Toast.LENGTH_SHORT).show()
            }
        }
    }
}
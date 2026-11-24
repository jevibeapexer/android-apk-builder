package com.example.sampleapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickCount = savedInstanceState?.getInt(STATE_CLICK_COUNT) ?: 0
        val clickButton = findViewById<Button>(R.id.clickButton)
        val countText = findViewById<TextView>(R.id.countText)
        updateCountText(countText)

        clickButton.setOnClickListener {
            clickCount++
            updateCountText(countText)

            if (clickCount % 5 == 0) {
                Toast.makeText(
                    this,
                    getString(R.string.click_milestone, clickCount),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(STATE_CLICK_COUNT, clickCount)
        super.onSaveInstanceState(outState)
    }

    private fun updateCountText(countText: TextView) {
        countText.text = resources.getQuantityString(R.plurals.click_count, clickCount, clickCount)
    }

    private companion object {
        const val STATE_CLICK_COUNT = "click_count"
    }
}

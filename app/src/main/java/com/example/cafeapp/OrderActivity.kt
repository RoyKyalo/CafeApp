package com.example.cafeapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Find the submit button and set its click listener
        findViewById<Button>(R.id.submit_order_button).setOnClickListener {
            // Create an intent to open OrderDetailsActivity
            val intent = Intent(this, OrderDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}

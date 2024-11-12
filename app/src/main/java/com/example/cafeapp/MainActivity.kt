package com.example.cafeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var mOrderMessage: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Handle insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the FAB and set up its click listener to launch OrderActivity
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            // Create an Intent to launch OrderActivity
            val intent = Intent(this, OrderActivity::class.java)
            // Pass the order message to OrderActivity if set
            intent.putExtra("orderMessage", mOrderMessage)
            // Start OrderActivity
            startActivity(intent)
        }
    }

    // Display a Toast message
    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    // Show a message when the donut image is clicked
    fun showDonutOrder(view: View) {
        mOrderMessage = "You ordered a donut."
        displayToast(mOrderMessage)
    }

    // Show a message when the ice cream sandwich image is clicked
    fun showIceCreamOrder(view: View) {
        mOrderMessage = "You ordered an ice cream sandwich."
        displayToast(mOrderMessage)
    }

    // Show a message when the froyo image is clicked
    fun showFroyoOrder(view: View) {
        mOrderMessage = "You ordered a Froyo."
        displayToast(mOrderMessage)
    }

    // Show a Snackbar message at the bottom of the screen when FAB is clicked
    fun startOrder(view: View) {
        Snackbar.make(
            view,
            "Not yet implemented Order functionality",
            Snackbar.LENGTH_LONG
        ).setAction("Action", null).show()
    }
}

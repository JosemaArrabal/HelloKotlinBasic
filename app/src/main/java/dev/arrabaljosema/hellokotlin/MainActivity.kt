package dev.arrabaljosema.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var message: String = findViewById<TextView>(R.id.main_welcome_textView).text.toString()
        Log.i("Message textView", message)
    }
}
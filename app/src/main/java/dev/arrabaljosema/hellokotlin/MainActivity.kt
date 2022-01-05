package dev.arrabaljosema.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)

        findViewById<Button>(R.id.main_play_button).setOnClickListener { speak() }
    }

    private fun speak() {
        var message: String = findViewById<TextView>(R.id.main_userText_editText).text.toString()
        if (message.isEmpty()){
            findViewById<TextView>(R.id.main_textToPlay_textView).text = "Has olvidado introducir un texto"
            message="Si no escribes nada no sabría que decirte"
        }
        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.main_textToPlay_textView).text = "¡¡Listo!! :)"
            tts!!.setLanguage(Locale.getDefault())
        } else {
            findViewById<TextView>(R.id.main_textToPlay_textView).text = "No disponible :("
        }
    }

    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}
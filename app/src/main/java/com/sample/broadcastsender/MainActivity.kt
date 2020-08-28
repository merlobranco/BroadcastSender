package com.sample.broadcastsender

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMessage: EditText
    private lateinit var receivedTextMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextMessage = findViewById(R.id.edit_text_message)
        receivedTextMessage = findViewById(R.id.text_view_message)
    }

    fun sendBroadcast(v: View) {
        val message = editTextMessage.text.toString()
        val intent = Intent()
        // Calling  explicitly the broadcast receiver of another App
        intent.setClassName("com.sample.broadcastreceiver", "com.sample.broadcastreceiver.ExampleBroadcastReceiver")
        intent.putExtra("ebr", message)
        sendBroadcast(intent)
    }
}

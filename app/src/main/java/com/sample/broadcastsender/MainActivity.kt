package com.sample.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMessage: EditText
    private lateinit var receivedTextMessage: TextView
    private lateinit var broadcastReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextMessage = findViewById(R.id.edit_text_message)
        receivedTextMessage = findViewById(R.id.text_view_message)

        broadcastReceiver = object: BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val receivedText = intent!!.getStringExtra("com.sample.broadcastreceiver.EXTRA_TEXT")
                receivedTextMessage.text = receivedText
            }
        }
    }

    fun sendBroadcast(v: View) {
        val message = editTextMessage.text.toString()
        val intent = Intent("com.sample.broadcastreceiver.EXAMPLE_ACTION")
        intent.putExtra("com.sample.broadcastreceiver.EXTRA_TEXT", message)
        sendBroadcast(intent)
    }

    /**
     * The App will be listening to the broadcast while the activity is alive
     */
    override fun onStart() {
        super.onStart()
        val filter = IntentFilter("com.sample.broadcastreceiver.EXAMPLE_ACTION")
        registerReceiver(broadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }
}

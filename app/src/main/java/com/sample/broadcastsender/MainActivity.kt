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
        val intent = Intent("com.sample.EXAMPLE_ACTION")

        // Required for calling the broadcast receivers registered statically: OrderedReceiver2 and OrderedReceiver3
        // OrderedReceiver1 was registered dynamically
        intent.setPackage("com.sample.broadcastreceiver")
//        intent.putExtra("ebr", message)

        val extras = Bundle()
        extras.putString("stringExtra", "start")

        /**
         * resultReceiver: the last broadcast receiver that will be executed
         * scheduler: param where we should provide the alternative thread where we want to trigger our broadcast receiver
         * the following 3 pieces of data will be sent to the next broadcast receiver and will be read, changed and sent to the next one
         */
        sendOrderedBroadcast(intent, null, SenderReceiver(), null, 0, "Start", extras)
    }
}

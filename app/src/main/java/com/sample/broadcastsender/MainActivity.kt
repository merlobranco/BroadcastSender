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

        // It checks which Apps of the phone have a broadcast receiver that matches the intent filter we defined in the intent
        val infos = packageManager.queryBroadcastReceivers(intent, 0)
        for (info in infos) {
            val cn = ComponentName(info.activityInfo.packageName, info.activityInfo.name)
            intent.component = cn
            intent.putExtra("ebr", message)
            sendBroadcast(intent)
        }
    }
}

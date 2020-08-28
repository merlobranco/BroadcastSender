package com.sample.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleBroadcastReceiver2: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent!!.getStringExtra("ebr")
        Toast.makeText(context, "EBR2: $message", Toast.LENGTH_SHORT).show()
    }
}
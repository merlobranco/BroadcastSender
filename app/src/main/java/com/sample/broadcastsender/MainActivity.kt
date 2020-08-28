package com.sample.broadcastsender

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendBroadCast(v: View) {
        val intent: Intent("com.sample.broadcastreceiver.EXAMPLE_ACTION")

    }
}

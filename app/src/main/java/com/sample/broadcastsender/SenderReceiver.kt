package com.sample.broadcastsender

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SenderReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        val message = intent!!.getStringExtra("ebr")

        // Retrieving the 3 pieces of data provided by the previous broadcast receiver
        var rc = resultCode
        var rd = resultData
        var re = getResultExtras(true) // If it is null will be initialized
        var se = re.getString("stringExtra")

        rc++
        se += "->SenderReceiver"

        var toastText = "SenderReceiver\nresultCode: $rc\nresultData: $rd\nstringExtra: $se"

        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        rd = "SenderReceiver"
        re.putString("stringExtra", se)

        setResult(rc, rd, re)

//        Toast.makeText(context, "EBR2: $message", Toast.LENGTH_SHORT).show()
    }
}
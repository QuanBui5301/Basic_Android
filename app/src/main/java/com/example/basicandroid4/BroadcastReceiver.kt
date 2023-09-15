package com.example.basicandroid4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        var intent_back : Intent = Intent(p0, MainActivity::class.java)
        intent_back.putExtra("fragment2", 2)
        p0!!.startActivity(intent_back)
    }
}
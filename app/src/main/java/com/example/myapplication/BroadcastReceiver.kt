package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        var action : Int = p1!!.getIntExtra("action", 0)
        var intent_back : Intent = Intent(p0, MyService2::class.java)
        intent_back.putExtra("action", action)
        p0!!.startService(intent_back)
    }
}
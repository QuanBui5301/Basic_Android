package com.example.basicandroid3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class BroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val connectivityManager : ConnectivityManager = p0!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val connectionInfo = connectivityManager.activeNetworkInfo
        if (connectionInfo != null && connectionInfo.isConnected) {
            Toast.makeText(p0, "Connect", Toast.LENGTH_SHORT).show()
        }
        else Toast.makeText(p0, "Disonnect", Toast.LENGTH_SHORT).show()
    }

}
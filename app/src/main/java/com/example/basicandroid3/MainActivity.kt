package com.example.basicandroid3

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btn_exam : Button
    private lateinit var btn_cancel : Button
    private lateinit var mBroadcastReceiver: BroadcastReceiver
    private var isReceiver : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent : Intent = Intent(this, BroadcastReceiver::class.java)
        btn_exam = findViewById(R.id.btn_exam)
        btn_cancel = findViewById(R.id.btn_cancel)
        btn_exam.setOnClickListener() {
            if (!isReceiver) {
                mBroadcastReceiver = BroadcastReceiver()
                val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
                registerReceiver(mBroadcastReceiver, intentFilter)
                !isReceiver
            }
        }
        btn_cancel.setOnClickListener() {
            if (isReceiver) {
                unregisterReceiver(mBroadcastReceiver)
                !isReceiver
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(mBroadcastReceiver)
        isReceiver = false
    }
}
package com.example.myapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var playbtn : Button
    lateinit var playbtn2 : Button
    lateinit var playbtn3 : Button
    lateinit var cancelbtn : Button
    lateinit var first_number : EditText
    lateinit var second_number : EditText
    private var mHandler : Handler = Handler()
    private var mMyService3 = MyService3()
    private var isServiceConnected : Boolean = false
    private var mServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            var myBinder : MyService3.MyBinder = p1 as MyService3.MyBinder
            mMyService3 = myBinder.calculate()
            Toast.makeText(this@MainActivity, "${mMyService3.ProcessCalculate(first_number.text.toString().toInt(), second_number.text.toString().toInt())}", Toast.LENGTH_SHORT).show()
            isServiceConnected = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isServiceConnected = false
        }

    }
    companion object {
        var state : Int = 1
        var song : Int = R.raw.music
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var music : Int = R.raw.music
        var intent : Intent = Intent(this, MyService1::class.java)
        var intent2 : Intent = Intent(this, MyService2::class.java)
        var intent3 : Intent = Intent(this, MyService3::class.java)
        intent.putExtra("music", music)
        playbtn = findViewById(R.id.playbtn1)
        playbtn2 = findViewById(R.id.playbtn2)
        playbtn3 = findViewById(R.id.playbtn3)
        cancelbtn = findViewById(R.id.playbtncancel)
        first_number = findViewById(R.id.first_number)
        second_number = findViewById(R.id.second_number)
        playbtn.setOnClickListener() {
            startService(intent)
            val runnable = object : Runnable {
                override fun run() {
                    if (state == 0) {
                        Log.d("Action", "Turn off")
                        stopService(intent)
                        System.exit(0)
                    }
                    mHandler.postDelayed(this, 1000)
                }
            }
            runnable.run()
        }
        playbtn2.setOnClickListener() {
            startService(intent2)
        }
        playbtn3.setOnClickListener() {
            bindService(intent3, mServiceConnection, Context.BIND_AUTO_CREATE)
        }
        cancelbtn.setOnClickListener() {
            if (isServiceConnected) {
                first_number.text.clear()
                second_number.text.clear()
                unbindService(mServiceConnection)
                !isServiceConnected
            }
        }
    }
}
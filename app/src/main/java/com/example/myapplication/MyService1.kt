package com.example.myapplication

import android.app.Activity
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultRegistry
import com.example.myapplication.MainActivity.Companion.state

class MyService1 : Service() {
    lateinit var mediaPlayer: MediaPlayer
    private var mHandler: Handler = Handler()
    override fun onCreate() {
        super.onCreate()
        Log.d("Action", "Play music")
        Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show()
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var music : Int = intent!!.getIntExtra("music", 0)
        mediaPlayer = MediaPlayer.create(this, music)
        mediaPlayer.start()

        val runnable = object : Runnable {
            override fun run() {
                if (!mediaPlayer.isPlaying) {
                    Log.d("Action", "Stop music")
                    state = 0
                    stopService(intent)
                }
                mHandler.postDelayed(this, 1000)
            }
        }
        runnable.run()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
        mediaPlayer.stop()
    }
}
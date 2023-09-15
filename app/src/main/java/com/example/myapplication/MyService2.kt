package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.myapplication.MainActivity.Companion.song
import com.example.myapplication.MyNotification.Companion.CHANNEL_ID


class MyService2 : Service() {
    lateinit var mediaPlayer: MediaPlayer
    private var close_action : Int = 1

    override fun onCreate() {
        super.onCreate()
        Log.d("Action", "Play music")
        Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show()
        mediaPlayer = MediaPlayer.create(this, song)
        mediaPlayer.start()
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        sendNotification()
        var action_receive : Int = intent!!.getIntExtra("action", 0)
        if (action_receive == close_action) {
            closeMusic(intent)
        }
        return START_STICKY
    }

    private fun closeMusic(intent:Intent) {
        stopService(intent)
    }

    private fun sendNotification() {
        var intent1:Intent = Intent(this, MainActivity::class.java)
        var pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0 , intent1, PendingIntent.FLAG_UPDATE_CURRENT)
        var remoteViews : RemoteViews = RemoteViews(getPackageName(), R.layout.notification_layout)
        remoteViews.setTextViewText(R.id.text_tittle, "Phát nhạc")
        remoteViews.setImageViewResource(R.id.img_song, R.drawable.ic_baseline_music_note_24)
        remoteViews.setImageViewResource(R.id.play_btn, R.drawable.ic_baseline_close_24)
        remoteViews.setOnClickPendingIntent(R.id.play_btn, getPendingIntent(this, close_action))


        var notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_baseline_music_note_24)
            .setSound(null)
            .setCustomContentView(remoteViews)
            .build()
        startForeground(1, notification)
        stopForeground(false)
    }

    private fun getPendingIntent(context : Context, action : Int) : PendingIntent {
        var intent : Intent = Intent(this, BroadcastReceiver::class.java)
        intent.putExtra("action", action)

        return PendingIntent.getBroadcast(context.applicationContext, action, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
    }
}
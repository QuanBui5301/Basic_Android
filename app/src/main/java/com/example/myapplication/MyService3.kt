package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService3 : Service() {
    private var mBinder : MyBinder = MyBinder()

    class MyBinder : Binder() {
        fun calculate() : MyService3 {
            return MyService3()
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Service 3", "onCreate")
    }
    override fun onBind(intent: Intent): IBinder {
        Log.d("Service 3", "onBind")
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("Service 3", "onUnBind")
        return super.onUnbind(intent)
    }

    fun ProcessCalculate(first : Int, second : Int) : Int {
        return (first + second)
    }

    override fun onDestroy() {
        Log.d("Service 3", "onDestroy")
        super.onDestroy()
    }

}
package com.example.basicandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent : Intent = Intent(applicationContext, MainActivity2::class.java)
        var number : Int = 10
        var bundle : Bundle = Bundle()
        bundle.putString("name", "SBD")
        button = findViewById(R.id.Button)
        intent.putExtra("number", number)
        intent.putExtras(bundle)
        button.setOnClickListener() {
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Life", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("Life", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life", "onDestroy")
    }
}
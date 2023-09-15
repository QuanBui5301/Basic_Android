package com.example.basicandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var intent : Intent = getIntent()
        var bundle: Bundle = intent.extras!!
        var namereceive : String = bundle.getString("name")!!
        var numberreceive : Int = intent.getIntExtra("number", 1)
        Toast.makeText(this, "$namereceive : $numberreceive", Toast.LENGTH_SHORT).show()
    }
}
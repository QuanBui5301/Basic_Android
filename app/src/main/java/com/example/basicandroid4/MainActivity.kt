package com.example.basicandroid4

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.basicandroid4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Replace {
    lateinit var mFragmentManager: FragmentManager
    lateinit var fragment1 : Fragment1
    lateinit var fragment2 : Fragment2
    lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFragmentManager = supportFragmentManager
        fragment1 = Fragment1(this)
        val fragmentTransaction = mFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout, fragment1)
        fragmentTransaction.commit()
        var intent : Intent = Intent(this, MainActivity2::class.java)
        button = findViewById(R.id.activity2)
        button.setOnClickListener() {
            startActivity(intent)
        }
    }

    override fun fragment2() {
        fragment2 = Fragment2()
        val fragmentReplace = mFragmentManager.beginTransaction()
        fragmentReplace.replace(R.id.frame_layout, fragment2)
        fragmentReplace.commit()
    }
}
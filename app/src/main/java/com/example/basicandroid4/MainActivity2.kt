package com.example.basicandroid4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class MainActivity2 : AppCompatActivity(), Replace {
    lateinit var mFragmentManager: FragmentManager
    lateinit var fragment1: Fragment1
    lateinit var fragment2: Fragment2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mFragmentManager = supportFragmentManager
        fragment1 = Fragment1(this)
        fragment2 = Fragment2()
        val fragmentTransaction = mFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frame_layout2, fragment1)
        fragmentTransaction.add(R.id.frame_layout1, fragment2)
        fragmentTransaction.commit()
    }

    override fun fragment2() {

    }
}
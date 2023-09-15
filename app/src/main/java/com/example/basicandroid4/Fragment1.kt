package com.example.basicandroid4

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RemoteViews
import com.example.basicandroid4.databinding.Fragment1Binding


class Fragment1(private var replace : Replace) : Fragment() {
    private lateinit var binding: Fragment1Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Life cycle fragment 1", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Life cycle fragment 1", "onCreate")
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(layoutInflater)
        val view : View = binding.root
        Log.d("Life cycle fragment 1", "onCreateView")
        binding.button.setOnClickListener() {
            replace.fragment2()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Life cycle fragment 1", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Life cycle fragment 1", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Life cycle fragment 1", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life cycle fragment 1", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life cycle fragment 1", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life cycle fragment 1", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Life cycle fragment 1", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life cycle fragment 1", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Life cycle fragment 1", "onDetach")
    }
}
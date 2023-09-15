package com.example.basicandroid4

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basicandroid4.databinding.Fragment2Binding


class Fragment2 : Fragment() {
    private lateinit var binding: Fragment2Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Life cycle fragment 2", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Life cycle fragment 2", "onCreate")
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(layoutInflater)
        val view : View = binding.root
        Log.d("Life cycle fragment 2", "onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Life cycle fragment 2", "onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Life cycle fragment 2", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Life cycle fragment 2", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life cycle fragment 2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life cycle fragment 2", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life cycle fragment 2", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Life cycle fragment 2", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life cycle fragment 2", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Life cycle fragment 2", "onDetach")
    }
}
package com.example.pipeline.spleshScreen

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.pipeline.R
import com.example.pipeline.databinding.FragmentSpleshBinding


class SpleshFragment : Fragment() {

    lateinit var binding: FragmentSpleshBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_splesh, container, false)


        val animation_time: Long = 2000
        Handler(Looper.myLooper()!!).postDelayed({

            findNavController().navigate(R.id.action_spleshFragment2_to_loginFragment)

        },animation_time)



        return view
    }

}
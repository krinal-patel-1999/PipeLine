package com.example.pipeline.forgotPassword

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.pipeline.R
import com.example.pipeline.databinding.FragmentForgotPasswordBinding


class ForgotPasswordFragment : Fragment() {

lateinit var binding: FragmentForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_forgot_password, container, false)
        binding.toolbarUseredit.tvProfile.text="Forgot Password"
        binding.tvDropMonumber.setOnClickListener{
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_countryCodeFragment)
        }
        binding.toolbarUseredit.imgArrow.setOnClickListener {
            findNavController().popBackStack()

        }

        val args = this.arguments
        if(args!=null) {
            var inputData = args?.get("countryno")
            var inputImg = args?.get("imgflag")
            binding.tvDropMonumber.text = inputData.toString()
            Log.e("krinal", inputImg.toString())
     // binding.tvDropMonumber.setCompoundDrawablesWithIntrinsicBounds(Integer.parseInt(inputImg.toString()), 0, 0, 0);
            //binding.tvDropMonumber.setCompoundDrawablePadding(-180);
        }
        return binding.root
    }


}
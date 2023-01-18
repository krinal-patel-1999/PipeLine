package com.example.pipeline.loginScreen

import android.graphics.Color
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pipeline.R
import com.example.pipeline.databinding.FragmentLoginBinding
import com.example.pipeline.model.BaseResponse
import com.google.android.material.snackbar.Snackbar


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
        binding.loginModel = viewModel
        binding.lifecycleOwner = this
       // viewModel.setBinding(binding)
        observ()


        // binding.btnLogin.setOnClickListener {
        //
        // }


        viewModel.loginError.observe(viewLifecycleOwner, Observer {
           // Snackbar.make(requireContext(),binding.root,it,Snackbar.LENGTH_SHORT).show()


                if (it.toString().equals("Valid response")){
                    Toast.makeText(requireActivity(), "LoginSucssessfull", Toast.LENGTH_SHORT).show()
                    viewModel.LoginUserVM(email = binding.etLoginEmail.text.toString(), password =binding.etLoginPassword.text.toString() )

            }else {

                    if (it.toString().equals("Please Enter email")) {

                        binding.etLogEmail.error = "Please Enter email"
                        binding.etLogEmail.requestFocus()
                        binding.etLoginEmail.setBackgroundResource(R.drawable.boxvalidation)
                        binding.tvLoginEmail.setTextColor(Color.parseColor("#FFD10033"))

                    } else if (it.toString().equals("Please Enter Password")) {
                        binding.etLogPassword.error = "Please Enter valid Password"
                        binding.etLogPassword.requestFocus()
                        binding.etLoginPassword.setBackgroundResource(R.drawable.boxvalidation)
                        binding.tvLoginPassword.setTextColor(Color.parseColor("#FFD10033"))
                    }
                }



        })




        binding.tvClickRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.tvForgotpass.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)

        }
        return binding.root
    }

    fun observ(){

      //  viewModel.LoginUserVM(email = binding.etLoginEmail.text.toString(), password =binding.etLoginPassword.text.toString() )

        viewModel.LoginResult.observe(viewLifecycleOwner) {
            Log.d("observe" , "observ : $viewModel.LoginResult.toString()")


            when (it) {
                is BaseResponse.Loading -> {

                }

                is BaseResponse.Success -> {
                    Toast.makeText(requireActivity(), "Login Succsesfully", Toast.LENGTH_SHORT).show()
                    processLogin(it.data)

                }

                is BaseResponse.Error -> {


                    Toast.makeText(requireActivity(), "Login Not Succsesfully", Toast.LENGTH_SHORT).show()

                }

                else -> {

                }
            }
        }

    }

    private fun processLogin(data: LoginResponse?) {

        val sesson = requireActivity().getSharedPreferences("token", AppCompatActivity.MODE_PRIVATE)
        val edit = sesson.edit()
        edit.putString("token",data?.data?.refreshToken.toString())
        if (edit.commit() ==true){
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }


}
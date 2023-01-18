package com.example.pipeline.loginScreen

import android.app.Activity
import android.app.Application
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isEmpty
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pipeline.R
import com.example.pipeline.databinding.FragmentLoginBinding
import com.example.pipeline.model.BaseResponse
import com.example.pipeline.repository.UserRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    //  lateinit var loginBinding: FragmentLoginBinding


    val LoginRepositori = UserRepository()
    val LoginResult: MutableLiveData<BaseResponse<LoginResponse>> = MutableLiveData()

    val loginError = MutableLiveData<String>()


    val email: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    //var context:Context = get

    private var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    //private var loginValidation = MutableLiveData<String>()

    // fun setBinding(binding: FragmentLoginBinding){
//    loginBinding = binding
//    } fun getLoginResult(): LiveData<String> = loginValidation


    fun LoginUserVM(email: String, password: String) {

        LoginResult.value = BaseResponse.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val loginRequest = LoginRequest(
                    email = email,
                    password = password,
                    deviceToken = "dr5GhMLpQAuBAJAolWm4Wl:APA91bGx-DQkDQJpnlPl_yUe1lAGvOnqTxY4cAZxqlJG-8ZaGgdSvPRyIaT4AbVeBnCQcNsL4r5FeemycHrQ-Y3abJ-T1DMSC-NJHDjq4gebvyfst5mE97g2wI5Pv_CMWeSkbZ1VDDq5",
                    platform = "Android",
                    version = "6.0.12"
                )
                val response = LoginRepositori.loginUserRepo(loginRequest = loginRequest)
                if (response?.code() == 200) {
                    LoginResult.postValue(BaseResponse.Success(response.body()))
                    Log.e("responsedata==", response.message())
                } else {
                    LoginResult.postValue(BaseResponse.Error(response?.message()))

                }

            } catch (ex: Exception) {
                LoginResult.postValue(BaseResponse.Error(ex.message))
            }
        }
    }


    fun createLoginValidation() {


        when {
            email.value.isNullOrEmpty() -> {
                loginError.value = "Please Enter email"

            }
            password.value.isNullOrEmpty() -> {
                loginError.value = "Please Enter Password"

            }
            email.value!!.isNotEmpty() && password.value!!.isNotEmpty() -> {
                loginError.value = "Valid response"
            }


        }


    }
}












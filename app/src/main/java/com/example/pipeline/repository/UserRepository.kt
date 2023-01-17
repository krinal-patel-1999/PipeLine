package com.example.pipeline.repository

import android.util.Log
import com.example.pipeline.api.UserApi
import com.example.pipeline.loginScreen.LoginRequest
import com.example.pipeline.loginScreen.LoginResponse
import retrofit2.Response

class UserRepository {

    suspend fun loginUserRepo(loginRequest: LoginRequest): Response<LoginResponse>? {
        Log.e("response","LoginRequest"+loginRequest.toString())
        return  UserApi.getApi()?.loginUserapi(loginRequest = loginRequest)
    }
}
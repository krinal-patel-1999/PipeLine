package com.example.pipeline.api

import com.example.pipeline.loginScreen.LoginRequest
import com.example.pipeline.loginScreen.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("v1/oauth/signin")
    suspend fun loginUserapi(@Body loginRequest: LoginRequest): Response<LoginResponse>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}
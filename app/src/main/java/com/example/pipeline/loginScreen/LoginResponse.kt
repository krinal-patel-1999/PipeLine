package com.example.pipeline.loginScreen


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    var `data`: Data? = null,
    @SerializedName("meta")
    var meta: Meta? = null
)
package com.example.pipeline.loginScreen


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("device_token")
    var deviceToken: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("password")
    var password: String? = null,
    @SerializedName("platform")
    var platform: String? = null,
    @SerializedName("version")
    var version: String? = null



)
{
    override fun toString(): String {
        return "LoginRequest(deviceToken=$deviceToken, email=$email, password=$password, platform=$platform, version=$version)"
    }

}

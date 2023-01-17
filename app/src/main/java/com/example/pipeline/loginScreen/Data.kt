package com.example.pipeline.loginScreen


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("access_token")
    var accessToken: String? = null,
    @SerializedName("expires_in")
    var expiresIn: Int? = null,
    @SerializedName("refresh_token")
    var refreshToken: String? = null,
    @SerializedName("token_type")
    var tokenType: String? = null,
    @SerializedName("user_detail")
    var userDetail: UserDetail? = null
)
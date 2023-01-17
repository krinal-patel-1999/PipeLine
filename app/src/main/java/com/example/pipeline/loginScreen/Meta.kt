package com.example.pipeline.loginScreen


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("message")
    var message: String? = null,
    @SerializedName("message_code")
    var messageCode: String? = null,
    @SerializedName("status")
    var status: Boolean? = null,
    @SerializedName("status_code")
    var statusCode: Int? = null
)
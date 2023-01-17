package com.example.pipeline.loginScreen


import com.google.gson.annotations.SerializedName

data class UserDetail(
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("first_name")
    var firstName: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("last_name")
    var lastName: String? = null,
    @SerializedName("profile_image")
    var profileImage: Any? = null,
    @SerializedName("role")
    var role: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("uuid")
    var uuid: String? = null
)
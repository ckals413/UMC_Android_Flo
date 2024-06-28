package com.example.floclone

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName(value= "isSuccess")val isSuccess:Boolean,
    @SerializedName(value= "code")val code:Int,
    @SerializedName(value= "message")val message:String,
    @SerializedName(value= "result") val result: Result?
)

data class Result(
    @SerializedName(value= "userIndx") var userIndx: Int,
    @SerializedName(value= "jwt") var jwt : String
)

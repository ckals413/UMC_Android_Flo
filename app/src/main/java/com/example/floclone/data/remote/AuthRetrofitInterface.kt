package com.example.floclone.data.remote

// 필요한 import 구문들
import com.example.floclone.data.entities.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthRetrofitInterface {
    @POST("/users")
    fun signUp(@Body user: User): Call<AuthResponse>

    @POST("/users/login")
    fun login(@Body user: User): Call<AuthResponse>

}
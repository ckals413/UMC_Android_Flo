package com.example.floclone

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//맨 뒤에 /슬래쉬 를 붙이면 인터페이스 부분에서는 /슬래쉬를 빼고 적어야함.
const val BASE_URL = "https://edu-api-test.softsquared.com"

fun getRetrofit(): Retrofit{
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit
}
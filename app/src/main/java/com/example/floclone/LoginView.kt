package com.example.floclone

interface LoginView {
    fun oSnLoginSuccess(code : Int, result : Result )
    fun oSnLoginFailure()
}
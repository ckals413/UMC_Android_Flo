package com.example.floclone.ui.signin

import com.example.floclone.data.remote.Result

interface LoginView {
    fun oSnLoginSuccess(code : Int, result : Result)
    fun oSnLoginFailure()
}
package com.example.floclone.ui.main.look

import com.example.floclone.FloChartResult


interface LookView {
    fun onGetSongLoading()
    fun onGetSongSuccess(code: Int, result: FloChartResult)
    fun onGetSongFailure(code: Int, message: String)
}
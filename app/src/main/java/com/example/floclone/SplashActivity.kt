package com.example.floclone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.floclone.databinding.ActivitySplashBinding

//매니패스트에 등록하고-> intentFilter로 처음에 실행되게 설정
class SplashActivity : AppCompatActivity() {
    //카멜 표기식 (activity_song
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
                            startActivity(Intent(this,MainActivity::class.java))
        },2000)
    }
}
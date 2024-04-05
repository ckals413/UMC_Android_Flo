package com.example.floclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//뷰바인딩을 위해 임포트 함수를 사용하기 위해?
import com.example.floclone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {
    //lateinit은 나중에 초기화 될것을 나타냄
    // ActivityMainBinding은 레이아웃 파일이름에 Binding을 추가한이름
    lateinit var binding : ActivityMainBinding // 뷰 바인딩 함수

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}
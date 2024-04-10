package com.example.floclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(binding.root)

        val song = Song(binding.mainPlayTitleTv.text.toString(),binding.mainPlaySingerTv.text.toString())

        binding.mainPlayBar.setOnClickListener {
            //어디로 갈지 설정
            //mainPlayBar를 눌렀을 때 SongActivity로 전환
            //startActivity(Intent(this,SongActivity::class.java))
            val intent = Intent(this,SongActivity::class.java)
            intent.putExtra("title",song.title)
            intent.putExtra("singer",song.singer)
            startActivity(intent)
        }

        initBottomNavigation()

        Log.d("Song",song.title+song.singer)
    }

    private fun initBottomNavigation() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}
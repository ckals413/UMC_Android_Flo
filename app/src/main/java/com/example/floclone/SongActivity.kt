package com.example.floclone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.floclone.databinding.ActivitySongBinding

//AppCompatActivity 상속을 받아야함 안드로이드에서 액티비티 기능을 사용할 수 있게 만들어둔 클래스
// 소괄호 ()를 상속받을 때는 넣어줘야함
class SongActivity : AppCompatActivity(){
    //선언은 지금하지만 나중에 초기화 할게
    //카멜 표기식
    lateinit var binding : ActivitySongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //바인딩 초기화
        //이렇게 하는 형식을 기억한다!(바인딩)
        binding = ActivitySongBinding.inflate(layoutInflater)
        //최상단 (root)
        setContentView(binding.root)

        //밑에 버튼 클릭했을 때
        binding.songDownIb.setOnClickListener{
            //songActivity화면 전환 종료
            finish()
        }
        binding.songMiniplayerIv.setOnClickListener {
            setPlayerStatus(false)
        }
        binding.songPauseIv.setOnClickListener {
            setPlayerStatus(true)
        }
        if(intent.hasExtra("title")&&intent.hasExtra("singer")){
            binding.songMusicTitleTv.text=intent.getStringExtra("title")
            binding.songSingerNameTv.text=intent.getStringExtra("singer")
        }

    }
    private fun setPlayerStatus(isPlaying :Boolean){
        if(isPlaying){
            binding.songMiniplayerIv.visibility= View.VISIBLE
            binding.songPauseIv.visibility = View.GONE
        }
        else{
            binding.songMiniplayerIv.visibility= View.GONE
            binding.songPauseIv.visibility = View.VISIBLE
        }
    }
}
package com.example.floclone

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.floclone.databinding.ActivitySongBinding

//AppCompatActivity 상속을 받아야함 안드로이드에서 액티비티 기능을 사용할 수 있게 만들어둔 클래스
// 소괄호 ()를 상속받을 때는 넣어줘야함
class SongActivity : AppCompatActivity(){
    //선언은 지금하지만 나중에 초기화 할게
    //카멜 표기식
    lateinit var binding : ActivitySongBinding


    private var isRepeatEnabled = false // 반복 재생 활성화 상태 저장
    private var isRandomEnabled = false // 랜덤 재생 활성화 상태 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //바인딩 초기화
        //이렇게 하는 형식을 기억한다!(바인딩)
        binding = ActivitySongBinding.inflate(layoutInflater)
        //최상단 (root)
        setContentView(binding.root)

        //반복재생
        binding.songRepeatIv.setOnClickListener{
            setRepeatStatus()
        }
        //랜덤재생
        binding.songRandomIv.setOnClickListener {
            setRandomStatus()
        }


        //밑에 버튼 클릭했을 때 (오른쪽 상단, 아래 화살표)
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
        //클릭했을 때 값 가져오기? //인텐트가 올 수 도있고 안올수도 있어서 if문으로
        if(intent.hasExtra("title")&&intent.hasExtra("singer")){
            binding.songMusicTitleTv.text=intent.getStringExtra("title")
            binding.songSingerNameTv.text=intent.getStringExtra("singer")
        }

    }

    //재생 버튼 변경
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

    //반복 재생 버튼변경
    private fun setRepeatStatus() {
        isRepeatEnabled = !isRepeatEnabled // 상태 토글
        if (isRepeatEnabled) {
            // 반복 재생 활성화: 색상을 flo색으로 변경
            val color = ContextCompat.getColor(applicationContext, R.color.flo) // 컨텍스트와 색상 지정
            binding.songRepeatIv.setColorFilter(
                color,
                android.graphics.PorterDuff.Mode.SRC_ATOP
            ) // 적용할 포터더프 모드
           // Toast.makeText(applicationContext, "반복 재생 활성화", Toast.LENGTH_SHORT).show()
        } else {
            // 반복 재생 비활성화: 색상 필터 제거
            binding.songRepeatIv.clearColorFilter()
           // Toast.makeText(applicationContext, "반복 재생 비활성화", Toast.LENGTH_SHORT).show()
        }
    }

    //랜덤 재생 버튼변경
    private fun setRandomStatus() {
        isRandomEnabled = !isRandomEnabled // 상태 토글
        if (isRandomEnabled) {
            // 반복 재생 활성화: 색상을 flo색으로 변경
            val color = ContextCompat.getColor(applicationContext, R.color.flo) // 컨텍스트와 색상 지정
            binding.songRandomIv.setColorFilter(
                color,
                android.graphics.PorterDuff.Mode.SRC_ATOP
            ) // 적용할 포터더프 모드
           // Toast.makeText(applicationContext, "랜덤 재생 활성화", Toast.LENGTH_SHORT).show()
        } else {
            // 반복 재생 비활성화: 색상 필터 제거
            binding.songRandomIv.clearColorFilter()
            //Toast.makeText(applicationContext, "랜덤 재생 비활성화", Toast.LENGTH_SHORT).show()
        }
    }



}
package com.example.floclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.floclone.databinding.FragmentHomeBinding


// 여기 HomeFragmet 클래스는 다시 해봐야함 .from 미니

//Fragment를 상속받음
class HomeFragment : Fragment() {
    //FragmentHomeBinding은 레이아웃 파일에 따라 자동으로 생성된 바인딩 클래스
    private lateinit var binding : FragmentHomeBinding // 뷰 바인딩

    //onViewCreated() 메서드는 Fragment의 뷰가 생성된 후 호출
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    //onCreateView() 메서드는 Fragment의 UI를 생성하고 반환
    // 이 메서드를 오버라이드하여 Fragment의 뷰를 초기화하고 뷰 바인딩을 설정
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.homeTodayAlbum1Iv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.frame_layout, AlbumFragment()).commitAllowingStateLoss()
        }

        return binding.root
    }

}
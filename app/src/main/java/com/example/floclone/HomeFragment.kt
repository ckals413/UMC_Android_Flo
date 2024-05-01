package com.example.floclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
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

        val bannerAdapter= BannerVPAdapter(this)
        //이미지도 함께 넣어줌 -> BannerFragment.kt에서 인자 값을 int형으로 받음
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdapter.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        //뷰페이저와 어댑터 연결
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL //좌우로 스크롤 되게 함

        return binding.root
    }

}
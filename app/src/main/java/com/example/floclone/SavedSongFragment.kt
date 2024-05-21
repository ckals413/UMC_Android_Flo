package com.example.floclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.floclone.databinding.FragmentAlbumBinding
import com.example.floclone.databinding.FragmentDetailBinding
import com.example.floclone.databinding.FragmentLockerSavedsongBinding
import com.example.floclone.databinding.FragmentVideoBinding

class SavedSongFragment : Fragment(){
    private var songDatas = ArrayList<Album>()

    lateinit var binding: FragmentLockerSavedsongBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLockerSavedsongBinding.inflate(inflater,container,false)

        //데이터 리스트 생성 더미 데이터
        songDatas.apply {
            add(Album("내일의 우리","카더가든",R.drawable.img_album_exp3))
            add(Album("Shake It Off","Tatlor Swift",R.drawable.img_album_exp))
            add(Album("우리의 사랑은","찰리빈웍스",R.drawable.img_album_exp4))
            add(Album("Ling Ling","검정치마",R.drawable.img_album_exp5))
            add(Album("Surf boy","혁오",R.drawable.img_album_exp6 ))
        }

        return binding.root
    }
}
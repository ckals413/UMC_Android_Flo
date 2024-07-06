package com.example.floclone.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.floclone.databinding.FragmentHomeRecommend2Binding

class HomeRecommendFragment2 : Fragment(){
    lateinit var binding: FragmentHomeRecommend2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeRecommend2Binding.inflate(inflater,container,false)
        //binding.bannerImageIv.setImageResource(imgRes)
        return binding.root
    }
}
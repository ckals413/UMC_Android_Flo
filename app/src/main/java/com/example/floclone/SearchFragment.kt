package com.example.floclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.floclone.databinding.FragmentLookBinding
import com.example.floclone.databinding.FragmentSearchBinding


class SearchFragment: Fragment() {
    lateinit var binding:FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }
}



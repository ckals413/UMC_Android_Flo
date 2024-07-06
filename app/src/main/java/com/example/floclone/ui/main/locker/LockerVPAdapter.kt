package com.example.floclone.ui.main.locker


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.floclone.ui.main.locker.musicfile.MusicFileFragment
import com.example.floclone.ui.main.locker.savedsong.SavedAlbumFragment
import com.example.floclone.ui.main.locker.savedsong.SavedSongFragment

//import com.example.flo.databinding.FragmentLockerMusicfileBinding

class LockerVPAdapter (fragment : Fragment) : FragmentStateAdapter(fragment) {
    //여기에서 getItemCount값을 2를 안하고 3이였는데 앱이 튕기는 현상이 발생됨
    override fun getItemCount(): Int  = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> SavedSongFragment()
            1 -> MusicFileFragment()
            else -> SavedAlbumFragment()
        }
    }
}
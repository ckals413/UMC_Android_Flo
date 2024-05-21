package com.example.floclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.databinding.ItemSongBinding
import java.util.ArrayList

class SavedSongRVAdapter(private val savedSongList: ArrayList<SavedSong>): RecyclerView.Adapter<SavedSongRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SavedSongRVAdapter.ViewHolder {
        val binding: ItemSongBinding = ItemSongBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedSongRVAdapter.ViewHolder, position: Int) {
        holder.bind(savedSongList[position])
    }

    override fun getItemCount(): Int = savedSongList.size

    inner class ViewHolder(val binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(savedSong: SavedSong){
            binding.itemSongTitleTv.text = savedSong.title
            binding.itemSongSingerTv.text = savedSong.singer
            binding.itemSongImgIv.setImageResource(savedSong.coverImg!!)
        }
    }

}


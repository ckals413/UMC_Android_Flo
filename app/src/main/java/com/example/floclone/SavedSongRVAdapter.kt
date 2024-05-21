package com.example.floclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.databinding.ItemSongBinding
import java.util.ArrayList

class SavedSongRVAdapter(private val savedSongList: ArrayList<SavedSong>): RecyclerView.Adapter<SavedSongRVAdapter.ViewHolder>() {

    interface MyItemClickLitener{
        fun onItemClick()
        fun onRemoveSavedSong(position: Int)

    }

    private lateinit var  mItemClickListener: MyItemClickLitener
    fun setMyItemClickListener(itemClickLitener: MyItemClickLitener){
        mItemClickListener = itemClickLitener
    }

    fun addItem(savedSong: SavedSong){
        savedSongList.add(savedSong)
        notifyDataSetChanged()
    }
    fun removeItem(position: Int){
        savedSongList.removeAt(position)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SavedSongRVAdapter.ViewHolder {
        val binding: ItemSongBinding = ItemSongBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedSongRVAdapter.ViewHolder, position: Int) {
        holder.bind(savedSongList[position])
        //holder.itemView.setOnClickListener{mItemClickListener.onItemClick()} //아이템이 클릭되었을 때 전체부분
        holder.binding.itemSongMoreIv.setOnClickListener { mItemClickListener.onRemoveSavedSong(position) }//점3개 눌렀을 때

        holder.binding.itmeSongMixonTg.apply {
            isClickable = true
            isFocusable = true
            setOnClickListener {
                visibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
                holder.binding.itmeSongMixoffTg.visibility = if (visibility == View.GONE) View.VISIBLE else View.GONE
            }
        }

        holder.binding.itmeSongMixoffTg.apply {
            isClickable = true
            isFocusable = true
            setOnClickListener {
                visibility = if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
                holder.binding.itmeSongMixonTg.visibility = if (visibility == View.GONE) View.VISIBLE else View.GONE
            }
        }

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


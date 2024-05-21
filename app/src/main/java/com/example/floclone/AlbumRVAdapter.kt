package com.example.floclone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.floclone.databinding.ItemAlbumBinding
import java.util.ArrayList

class AlbumRVAdapter (private val albumList: ArrayList<Album>): RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>(){

    interface MyItemClickLitener{
        fun onItemClick(album: Album) //데이터도 같이
        fun onRemoveAlbum(position: Int)
    }

    private lateinit var  mItemClickListener: MyItemClickLitener
    fun setMyItemClickListener(itemClickLitener: MyItemClickLitener){
        mItemClickListener = itemClickLitener
    }

    fun addItem(album: Album){
        albumList.add(album)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        albumList.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AlbumRVAdapter.ViewHolder {
        //뷰 홀더 생성될 때 호출되는 함수
        val binding: ItemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albumList[position])
        //클릭 이벤트 처리
        //클릭 인터페이스 처리
        //holder.itemView.setOnClickListener{ mItemClickListener.onItemClick(albumList[position])}
        holder.binding.itemAlbumTitleTv.setOnClickListener{mItemClickListener.onRemoveAlbum(position)}
    }

    //마지막이 언젠지 알 수 있음
    override fun getItemCount(): Int = albumList.size

    inner class ViewHolder(val binding: ItemAlbumBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(album: Album) {
            binding.itemAlbumTitleTv.text = album.title
            binding.itemAlbumSingerTv.text = album.singer
            binding.itemAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }

    }

}
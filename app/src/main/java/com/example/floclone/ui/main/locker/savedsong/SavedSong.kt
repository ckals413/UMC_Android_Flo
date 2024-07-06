package com.example.floclone.ui.main.locker.savedsong
import com.example.floclone.data.entities.Song
import java.util.ArrayList

data class SavedSong(
    var title: String? = "",
    var singer: String? = "",
    var coverImg: Int? = null,
    var isToggled: Boolean = false, // 토글 상태를 저장하는 변수
    var songs: ArrayList<Song>? = null
)




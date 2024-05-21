package com.example.floclone
import java.util.ArrayList

data class SavedSong(
    var title: String? = "",
    var singer: String? = "",
    var coverImg: Int? = null,
    var songs: ArrayList<Song>? = null
)




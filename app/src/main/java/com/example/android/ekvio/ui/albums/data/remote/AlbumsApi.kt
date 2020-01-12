package com.example.android.ekvio.ui.albums.data.remote

import com.example.android.ekvio.ui.albums.presentation.AlbumsDTOList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AlbumsApi {

    @GET("/albums")
    @Headers("Content-Type: application/json")
    suspend fun getAlbums(): AlbumsDTOList
}
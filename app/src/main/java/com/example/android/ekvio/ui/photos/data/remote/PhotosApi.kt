package com.example.android.ekvio.ui.photos.data.remote

import com.example.android.ekvio.ui.photos.presentation.PhotosDTOList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PhotosApi {

    @GET("/photos")
    @Headers("Content-Type: application/json")
    suspend fun getPhotosByAlbumId(@Query("albumId") albumId: Long): PhotosDTOList
}
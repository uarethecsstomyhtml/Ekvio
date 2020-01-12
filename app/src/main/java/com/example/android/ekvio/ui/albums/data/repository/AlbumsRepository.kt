package com.example.android.ekvio.ui.albums.data.repository

import com.example.android.ekvio.ui.albums.domain.usecase.GetAlbumsUseCase
import com.example.android.ekvio.ui.albums.presentation.AlbumsDTOList

interface AlbumsRepository {

    suspend fun getAlbums(): AlbumsDTOList
}
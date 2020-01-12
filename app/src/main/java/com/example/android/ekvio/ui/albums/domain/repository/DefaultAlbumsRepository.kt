package com.example.android.ekvio.ui.albums.domain.repository

import com.example.android.ekvio.ui.albums.data.remote.AlbumsApi
import com.example.android.ekvio.ui.albums.data.repository.AlbumsRepository
import com.example.android.ekvio.ui.albums.domain.usecase.GetAlbumsUseCase
import com.example.android.ekvio.ui.albums.presentation.AlbumsDTOList

class DefaultAlbumsRepository(private val albumsApi: AlbumsApi): AlbumsRepository {

    override suspend fun getAlbums(): AlbumsDTOList {
        return albumsApi.getAlbums()
    }

}
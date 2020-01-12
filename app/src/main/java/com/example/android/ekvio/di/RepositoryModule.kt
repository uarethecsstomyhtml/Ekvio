package com.example.android.ekvio.di

import com.example.android.ekvio.ui.albums.data.repository.AlbumsRepository
import com.example.android.ekvio.ui.albums.domain.repository.DefaultAlbumsRepository
import com.example.android.ekvio.ui.photos.data.repository.PhotosRepository
import com.example.android.ekvio.ui.photos.domain.repository.DefaultPhotosRepository
import org.koin.dsl.module


val repositoryModule = module {
    factory { DefaultAlbumsRepository(albumsApi = get()) as AlbumsRepository }
    factory { DefaultPhotosRepository(photosApi = get()) as PhotosRepository }
}


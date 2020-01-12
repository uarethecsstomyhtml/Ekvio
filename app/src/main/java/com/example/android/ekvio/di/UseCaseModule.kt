package com.example.android.ekvio.di

import com.example.android.ekvio.ui.albums.domain.usecase.GetAlbumsUseCase
import com.example.android.ekvio.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import org.koin.dsl.module


val useCaseModule = module {
    factory { GetAlbumsUseCase(albumsRepository = get()) }
    factory { GetPhotosByAlbumIdUseCase(photosRepository = get()) }
}


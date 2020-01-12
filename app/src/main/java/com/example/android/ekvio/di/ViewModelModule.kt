package com.example.android.ekvio.di

import com.example.android.ekvio.ui.albums.presentation.AlbumsViewModel
import com.example.android.ekvio.ui.photos.presentation.PhotosViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AlbumsViewModel(getAlbumsUseCase = get()) }
    viewModel { PhotosViewModel(getPhotosByAlbumIdUseCase = get()) }
}
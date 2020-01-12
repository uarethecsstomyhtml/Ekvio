package com.example.android.ekvio.ui.photos.data.repository

import com.example.android.ekvio.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import com.example.android.ekvio.ui.photos.presentation.PhotosDTOList

interface PhotosRepository {

   suspend fun getPhotosByAlbumId(params: GetPhotosByAlbumIdUseCase.Params): PhotosDTOList
}
package com.example.android.ekvio.ui.photos.domain.usecase

import com.example.android.ekvio.base.domain.Either
import com.example.android.ekvio.base.domain.Failure
import com.example.android.ekvio.ui.photos.data.repository.PhotosRepository
import com.example.android.ekvio.ui.photos.presentation.BaseGetPhotosByAlbumIdUseCase
import com.example.android.ekvio.ui.photos.presentation.PhotosDTOListEither

class GetPhotosByAlbumIdUseCase(
    private val photosRepository: PhotosRepository
) : BaseGetPhotosByAlbumIdUseCase() {


    override suspend fun run(params: Params): PhotosDTOListEither {
        return try {
            val comments = photosRepository.getPhotosByAlbumId(params)
            Either.Right(comments)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val postId: Long
    )

}
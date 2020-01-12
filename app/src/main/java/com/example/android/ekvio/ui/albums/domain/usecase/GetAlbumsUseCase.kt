package com.example.android.ekvio.ui.albums.domain.usecase

import com.example.android.ekvio.base.domain.Either
import com.example.android.ekvio.base.domain.Failure
import com.example.android.ekvio.ui.albums.data.repository.AlbumsRepository
import com.example.android.ekvio.ui.albums.presentation.AlbumsDTOListEither
import com.example.android.ekvio.ui.albums.presentation.BaseGetAlbumsUseCase

class GetAlbumsUseCase(private val albumsRepository: AlbumsRepository) : BaseGetAlbumsUseCase() {

    override suspend fun run(params: Params): AlbumsDTOListEither {
        return try {
            val albums = albumsRepository.getAlbums()
            Either.Right(albums)
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.FeatureFailure(e))
        }
    }

    data class Params(
        val isRemote: Boolean = true
    )

}
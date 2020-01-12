package com.example.android.ekvio.ui.photos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.ekvio.R.drawable.ic_launcher_background
import com.example.android.ekvio.ResultState.Success
import com.example.android.ekvio.base.domain.Failure
import com.example.android.ekvio.extension.setError
import com.example.android.ekvio.extension.setLoading
import com.example.android.ekvio.extension.setSuccess
import com.example.android.ekvio.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import timber.log.Timber

class PhotosViewModel(private val getPhotosByAlbumIdUseCase: GetPhotosByAlbumIdUseCase) : ViewModel() {

    private val defaultPhotos = listOf(
        PhotoUi(1, "title1", null, null, ic_launcher_background),
        PhotoUi(2, "title2", null, null, ic_launcher_background),
        PhotoUi(3, "title3", null, null, ic_launcher_background)
    )

    private val _photosUi = PhotoUiListResultMutable().apply {
        setLoading()
    }
    val photosUi: PhotoUiListResultLive
        get() = _photosUi

    private val _photosClick = PhotoClickMutable()
    val photosClick: PhotoClickLive
        get() = _photosClick

    fun loadPhotos(albumId: Long) {
        val params = GetPhotosByAlbumIdUseCase.Params(albumId)
        getPhotosByAlbumIdUseCase.invoke(viewModelScope, params) { it.either(::handleFailure, ::handleSuccess) }
    }

    fun onClickItem() {
        _photosClick.value = (_photosUi.value as Success).data.toTypedArray()
    }

    private fun handleFailure(failure: Failure) {
        Timber.e("handleFailure ${failure.exception}")
        _photosUi.setError(failure.exception)
    }

    private fun handleSuccess(photos: PhotosDTOList) {
        Timber.e("handleSuccess, photos = $photos")
        _photosUi.setSuccess(mapToPresentation(photos))
    }

    private fun mapToPresentation(albums: PhotosDTOList): PhotoUiList {
        return albums.map { PhotoUi(it.id, it.title, it.url, it.thumbnailUrl) }
    }

    fun loadDefaultPhotos() {
        _photosUi.setSuccess(defaultPhotos)
    }


}
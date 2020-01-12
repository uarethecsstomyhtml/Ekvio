package com.example.android.ekvio.ui.photos.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.ekvio.base.domain.BaseUseCase
import com.example.android.ekvio.base.domain.Either
import com.example.android.ekvio.base.domain.Failure
import com.example.android.ekvio.ResultState
import com.example.android.ekvio.base.entity.NetworkResponse
import com.example.android.ekvio.ui.photos.domain.usecase.GetPhotosByAlbumIdUseCase
import com.example.android.ekvio.ui.photos.entity.PhotoDTO

typealias PhotosDTOList = List<PhotoDTO>

typealias PhotosDTOListNetworkResponse = NetworkResponse<PhotosDTOList>
typealias BaseGetPhotosByAlbumIdUseCase = BaseUseCase<PhotosDTOList, GetPhotosByAlbumIdUseCase.Params>
typealias PhotosDTOListEither = Either<Failure, PhotosDTOList>

typealias PhotoUiList = List<PhotoUi>
typealias PhotoUiListResultMutable = MutableLiveData<ResultState<List<PhotoUi>>>
typealias PhotoUiListResultLive = LiveData<ResultState<List<PhotoUi>>>
typealias PhotoClickMutable = MutableLiveData<Array<PhotoUi>>
typealias PhotoClickLive = LiveData<Array<PhotoUi>>
typealias PhotoClickListener = (PhotoUi) -> Unit


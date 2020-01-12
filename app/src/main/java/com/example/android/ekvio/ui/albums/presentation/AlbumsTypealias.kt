package com.example.android.ekvio.ui.albums.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.ekvio.base.domain.BaseUseCase
import com.example.android.ekvio.base.domain.Either
import com.example.android.ekvio.base.domain.Failure
import com.example.android.ekvio.ResultState
import com.example.android.ekvio.base.entity.NetworkResponse
import com.example.android.ekvio.ui.albums.domain.usecase.GetAlbumsUseCase
import com.example.android.ekvio.ui.albums.entity.AlbumDTO

typealias AlbumsDTOList = List<AlbumDTO>

typealias AlbumsDTOListNetworkResponse = NetworkResponse<AlbumsDTOList>
typealias BaseGetAlbumsUseCase = BaseUseCase<AlbumsDTOList, GetAlbumsUseCase.Params>
typealias AlbumsDTOListEither = Either<Failure, AlbumsDTOList>

typealias AlbumsUiList = List<AlbumUi>
typealias AlbumsUiListMutable = MutableLiveData<ResultState<AlbumsUiList>>
typealias AlbumsUiListLive = LiveData<ResultState<AlbumsUiList>>
typealias AlbumClickListener = (AlbumUi) -> Unit


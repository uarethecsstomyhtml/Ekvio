package com.example.android.ekvio.ui.photos.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.ekvio.R.layout.fragment_photos
import com.example.android.ekvio.ResultState
import com.example.android.ekvio.ResultState.*
import com.example.android.ekvio.extension.gone
import com.example.android.ekvio.extension.visible
import com.example.android.ekvio.ui.photos.presentation.PhotosFragmentDirections.Companion.actionPhotosFragmentToPhotoDetailsFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.content_loading.*
import kotlinx.android.synthetic.main.fragment_photos.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class PhotosFragment : Fragment(fragment_photos) {

    private val args: PhotosFragmentArgs by navArgs()
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val viewModel: PhotosViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRv()
        loadPhotos()
        observeChangePhotos()
        observeChangePhotosUrls()
    }

    private fun setupRv() {
        Timber.d("setupRv")
        rvPhotos.adapter = adapter
    }

    private fun loadPhotos() {
        Timber.d("loadPhotos")
        viewModel.loadPhotos(args.albumId)
    }

    private fun observeChangePhotos() {
        Timber.d("observeChangePhotos")
        viewModel.photosUi.observe(this, Observer(::onChangePhotos))
    }

    private fun onChangePhotos(response: ResultState<PhotoUiList>) {
        Timber.d("onChangePhotos, response = $response")
        when(response) {
            is Loading -> pbLoading.visible()
            is Success -> onSuccess(response.data)
            is Error -> onError()
        }
    }

    private fun hideLoading() {
        pbLoading.gone()
    }

    private fun onSuccess(photos: PhotoUiList) {
        hideLoading()
        when {
            photos.isEmpty() -> loadDefaultPhotos()
            else -> photos.forEach {  adapter.add(PhotoItem(it, ::onClickItem)) }
        }
    }

    private fun onError() {
        hideLoading()
        loadDefaultPhotos()
    }

    private fun loadDefaultPhotos() {
        viewModel.loadDefaultPhotos()
    }

    private fun onClickItem(photo: PhotoUi) {
        viewModel.onClickItem()
    }

    private fun observeChangePhotosUrls() {
        viewModel.photosClick.observe(this, Observer(::onChangePhotosUrls))
    }

    private fun onChangePhotosUrls(photos: Array<PhotoUi>) {
        val action = actionPhotosFragmentToPhotoDetailsFragment(photos)
        findNavController().navigate(action)
    }
}
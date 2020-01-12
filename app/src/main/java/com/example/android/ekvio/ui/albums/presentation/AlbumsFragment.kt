package com.example.android.ekvio.ui.albums.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android.ekvio.R.layout.fragment_albums
import com.example.android.ekvio.ResultState
import com.example.android.ekvio.ResultState.*
import com.example.android.ekvio.extension.gone
import com.example.android.ekvio.extension.toast
import com.example.android.ekvio.extension.visible
import com.example.android.ekvio.ui.albums.presentation.AlbumsFragmentDirections.Companion.actionNavigationAlbumsToPhotosFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.content_loading.*
import kotlinx.android.synthetic.main.fragment_albums.*
import org.koin.android.ext.android.inject
import timber.log.Timber

class AlbumsFragment : Fragment(fragment_albums) {

    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val viewModel: AlbumsViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRv()
        loadAlbums()
        observeChangeAlbums()
    }

    private fun setupRv() {
        Timber.d("setupRv")
        rvAlbums.adapter = this@AlbumsFragment.adapter
    }

    private fun loadAlbums() {
        Timber.d("loadAlbums")
        viewModel.loadAlbums()
    }

    private fun observeChangeAlbums() {
        Timber.d("observeChangeAlbums")
        viewModel.albumsUi.observe(this, Observer(::onChangeAlbums))
    }

    private fun onChangeAlbums(response: ResultState<AlbumsUiList>) {
        Timber.d("onChangeAlbums")
        when(response) {
            is Loading -> pbLoading.visible()
            is Success -> onSuccess(response.data)
            is Error -> onError()
        }
    }

    private fun hideLoading() {
        pbLoading.gone()
    }

    private fun onSuccess(albums: AlbumsUiList) {
        hideLoading()
        albums.forEach { adapter.add(AlbumItem(it, ::onClickItem)) }
    }

    private fun onError() {
        hideLoading()
        context?.toast()
    }

    private fun onClickItem(albumUi: AlbumUi) {
        val action = actionNavigationAlbumsToPhotosFragment(albumId = albumUi.id)
        findNavController().navigate(action)
    }

}
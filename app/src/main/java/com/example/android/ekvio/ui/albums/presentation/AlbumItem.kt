package com.example.android.ekvio.ui.albums.presentation

import com.example.android.ekvio.R.layout.item_album
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_album.*

class AlbumItem(private val albumUi: AlbumUi, private val clickListener: AlbumClickListener) : Item() {

    override fun getLayout() = item_album

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder) {
            albumTitle.text = albumUi.title
            itemView.setOnClickListener { clickListener(albumUi) }
        }
    }

}
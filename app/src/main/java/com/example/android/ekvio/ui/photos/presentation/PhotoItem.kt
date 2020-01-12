package com.example.android.ekvio.ui.photos.presentation

import com.example.android.ekvio.R.layout.item_photo
import com.example.android.ekvio.extension.load
import com.example.android.ekvio.extension.loadRes
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_photo.*

class PhotoItem(private val photoUi: PhotoUi, private val clickListener: PhotoClickListener) : Item() {

    override fun getLayout() = item_photo

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder) {
            when {
                photoUi.url != null -> photoImg.load(photoUi.url)
                else -> photoImg.loadRes(photoUi.imgRes!!)
            }
            itemView.setOnClickListener { clickListener(photoUi) }
        }
    }

}
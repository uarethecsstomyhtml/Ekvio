package com.example.android.ekvio.ui.photos.presentation

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.android.ekvio.extension.load
import com.example.android.ekvio.extension.loadRes
import kotlinx.android.synthetic.main.item_photo.*
import timber.log.Timber

class PhotoViewPagerAdapter(
    private val context: Context,
    private val photos: Array<PhotoUi>
) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = photos.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Timber.d("instantiateItem, position = $position")
        val photoUi = photos[position]
        val imageView = ImageView(context)
        when {
            photoUi.url != null -> imageView.load(photoUi.url)
            else -> imageView.loadRes(photoUi.imgRes!!)
        }

        container.addView(imageView)

        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Timber.d("destroyItem, position = $position")
        container.removeView(`object` as View)
    }


}
package com.example.android.ekvio.ui.photos.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.android.ekvio.R.layout.fragment_photo_details
import kotlinx.android.synthetic.main.fragment_photo_details.*

class PhotoDetailsFragment : Fragment(fragment_photo_details) {

    private val args: PhotoDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViewPager()
    }

    private fun setupViewPager() {
        context?.let {
            vpPhotos.adapter = PhotoViewPagerAdapter(context!!, args.photos)
        }
    }

}
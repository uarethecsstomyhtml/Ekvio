package com.example.android.ekvio.ui.photos.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoUi(
    val id: Long,
    val title: String,
    val url: String?,
    val thumbnailUrl: String?,
    val imgRes: Int? = null
): Parcelable
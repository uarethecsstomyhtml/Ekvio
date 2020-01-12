package com.example.android.ekvio.base.entity


data class NetworkResponse<T> (
    val status: Int?,
    val data: T
)
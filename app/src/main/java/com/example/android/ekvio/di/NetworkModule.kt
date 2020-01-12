package com.example.android.ekvio.di

import android.app.Application
import com.example.android.ekvio.BuildConfig.DEBUG
import com.example.android.ekvio.ui.albums.data.remote.AlbumsApi
import com.example.android.ekvio.ui.photos.data.remote.PhotosApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://jsonplaceholder.typicode.com/"

val networkModule = module {
    single { httpCache(app = get()) }
    single { gson() }
    single { okHttpClient(cache = get()) }
    single { retrofitClient(gson = get(), okHttpClient = get()) }
}

val apiModule = module {
    single { albumsApi(retrofit = get()) }
    single { photosApi(retrofit = get()) }
}

private fun gson() : Gson {
    return GsonBuilder().create()
}

private fun httpCache(app : Application) : Cache {
    val cacheSize: Long = 10 * 1024 * 1024
    return Cache(app.cacheDir, cacheSize)
}

private fun okHttpClient(cache : Cache) : OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()

    httpLoggingInterceptor.level = if (DEBUG) BODY else NONE

    return with(OkHttpClient.Builder()) {
        cache(cache)
        addInterceptor(httpLoggingInterceptor)
        build()
    }
}

private fun retrofitClient(gson : Gson, okHttpClient: OkHttpClient): Retrofit  {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}

private fun albumsApi(retrofit: Retrofit) = retrofit.create(AlbumsApi::class.java)
private fun photosApi(retrofit: Retrofit) = retrofit.create(PhotosApi::class.java)




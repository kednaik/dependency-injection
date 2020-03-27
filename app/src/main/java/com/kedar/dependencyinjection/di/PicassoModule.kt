package com.kedar.dependencyinjection.di

import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [NetworkModule::class])
class PicassoModule {
    @Provides
    fun http3Downloader(okHttpClient: OkHttpClient):OkHttp3Downloader{
        return OkHttp3Downloader(okHttpClient)
    }
    @Provides
    fun picasso(context: Context,downloader: OkHttp3Downloader):Picasso{
        return Picasso.Builder(context).downloader(downloader).build()
    }
}
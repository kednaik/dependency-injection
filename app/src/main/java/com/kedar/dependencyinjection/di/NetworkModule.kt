package com.kedar.dependencyinjection.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File

@Module
class NetworkModule {

    @Provides
    fun networkCache(context: Context): Cache {
        val cacheFile = File(context.cacheDir, "NetworkCache")
        cacheFile.mkdirs()
        //25Mb cache
        return Cache(cacheFile, 25 * 1000 * 1000)
    }

    @Provides
    fun httpClient(cache:Cache):OkHttpClient{
        return OkHttpClient().newBuilder().cache(cache).build()
    }
}
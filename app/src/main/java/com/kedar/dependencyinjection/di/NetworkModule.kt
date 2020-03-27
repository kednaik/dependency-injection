package com.kedar.dependencyinjection.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kedar.dependencyinjection.api.UsersDataService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

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
    fun httpClient(cache: Cache): OkHttpClient {
        return OkHttpClient().newBuilder().cache(cache).build()
    }

    @Provides
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Singleton
    @Provides
    fun retrofit(gson: Gson, okHttpClient: OkHttpClient): UsersDataService {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(UsersDataService::class.java)
    }
}
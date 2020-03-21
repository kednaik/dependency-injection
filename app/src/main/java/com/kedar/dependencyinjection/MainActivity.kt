package com.kedar.dependencyinjection

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.logging.Logger


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as MyApplication).appComponent
        appComponent.inject(this)

        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()

        val cacheFile = File(this.cacheDir, "NetworkCache")
        cacheFile.mkdirs()

        val cache = Cache(cacheFile, 25 * 1000 * 1000)


        val okHttpClient = OkHttpClient()
            .newBuilder()
            .cache(cache)
            .build()

        val okHttpDownloader = OkHttp3Downloader(okHttpClient)

        val picasso = Picasso.Builder(this).downloader(okHttpDownloader).build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}

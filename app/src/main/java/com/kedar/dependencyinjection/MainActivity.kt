package com.kedar.dependencyinjection

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kedar.dependencyinjection.adapters.UsersRecyclerAdapter
import com.kedar.dependencyinjection.api.UsersDataService
import com.kedar.dependencyinjection.api.model.UsersDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var picasso: Picasso

    @Inject
    lateinit var dataService: UsersDataService

    lateinit var recyclerViewAdapter:UsersRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        val appComponent = (application as MyApplication).appComponent
        appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        fetchData()
    }

    private fun initView(){
        rvUsers.adapter = UsersRecyclerAdapter(this,picasso).apply {
            recyclerViewAdapter = this
        }
    }

    private fun fetchData(){
        dataService.getUsers().enqueue(object : Callback<UsersDetail> {
            override fun onFailure(call: Call<UsersDetail>, t: Throwable) {
                progressBar.hide()
                Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<UsersDetail>, response: Response<UsersDetail>) {
                progressBar.hide()
                recyclerViewAdapter.users = response.body()!!.data
            }
        })
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val appComponent = (application as MyApplication).appComponent
//        appComponent.inject(this)

//        val gsonBuilder = GsonBuilder()
//        val gson = gsonBuilder.create()
//
//        val cacheFile = File(this.cacheDir, "NetworkCache")
//        cacheFile.mkdirs()
//
//        val cache = Cache(cacheFile, 25 * 1000 * 1000)
//
//
//        val okHttpClient = OkHttpClient()
//            .newBuilder()
//            .cache(cache)
//            .build()
//
//        val okHttpDownloader = OkHttp3Downloader(okHttpClient)
//
//        val picasso = Picasso.Builder(this).downloader(okHttpDownloader).build()
//
//        val retrofit = Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl("https://randomuser.me/")
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//    }
}

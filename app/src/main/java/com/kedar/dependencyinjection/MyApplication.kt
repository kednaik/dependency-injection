package com.kedar.dependencyinjection

import android.app.Application
import com.kedar.dependencyinjection.di.AppComponent
import com.kedar.dependencyinjection.di.DaggerAppComponent

class MyApplication :Application(){
    val appComponent:AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}
package com.kedar.dependencyinjection.di

import android.content.Context
import com.kedar.dependencyinjection.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PicassoModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject(mainActivity: MainActivity)
}
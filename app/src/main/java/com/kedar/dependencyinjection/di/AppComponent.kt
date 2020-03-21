package com.kedar.dependencyinjection.di

import com.kedar.dependencyinjection.MainActivity
import dagger.Component

@Component(modules = [PicassoModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
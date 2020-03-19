package com.kedar.dependencyinjection.di

import com.kedar.dependencyinjection.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun inject(mainActivity: MainActivity)

//    fun getCar():Car
//    fun getBike():Bike
//    fun getCycle():Cycle
//    fun getTruck(): Truck
}
package com.kedar.dependencyinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kedar.dependencyinjection.model.Bike
import com.kedar.dependencyinjection.model.Car
import com.kedar.dependencyinjection.model.Cycle
import com.kedar.dependencyinjection.model.Truck
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var car:Car
    @Inject lateinit var bike: Bike
    @Inject lateinit var cycle:Cycle
    @Inject lateinit var truck: Truck

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as MyApplication).appComponent
        appComponent.inject(this)
//        val vehicle = appComponent.getCar()
//        val bike = appComponent.getBike()
//        val cycle = appComponent.getCycle()
//        val truck = appComponent.getTruck()
    }
}

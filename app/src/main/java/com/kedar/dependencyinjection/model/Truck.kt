package com.kedar.dependencyinjection.model

import javax.inject.Inject

class Truck @Inject constructor(val engine: Engine){
    fun state(isStart:Boolean){
        if (isStart){
            engine.ignite()
        }else{
            engine.powerOff()
        }
    }
}
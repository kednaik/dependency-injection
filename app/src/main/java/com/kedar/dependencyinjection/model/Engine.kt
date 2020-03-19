package com.kedar.dependencyinjection.model

import javax.inject.Inject

class Engine @Inject constructor(val fuel:Fuel) {
    fun ignite(){

    }

    fun powerOff(){

    }
}
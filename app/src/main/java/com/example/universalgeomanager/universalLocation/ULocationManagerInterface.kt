package com.example.universalgeomanager.universalLocation


interface ULocationManagerInterface {

    fun getLastLocation()

    fun requestLocationUpdates()

    fun removeLocationUpdates()

}
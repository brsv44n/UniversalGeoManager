package com.example.universalgeomanager.universalLocation

import com.example.universalgeomanager.models.Location

//TODO лишнее, можно выпилить
interface ULocationManagerInterface {

    fun getLastLocation(): TaskWrapper<Location>

    fun requestLocationUpdates(request: LocationRequest): TaskWrapper<Any>

    fun removeLocationUpdates(): TaskWrapper<Any>

    //TODO Add more methods if discovered
}
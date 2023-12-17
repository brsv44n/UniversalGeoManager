package com.example.universalgeomanager.models

class Location {

    private var latitude: Double? = null
    private var longitude: Double? = null

    fun getLatitude(): Double = latitude.let { latitude!! }
    fun getLongitude(): Double = longitude.let { longitude!! }

}
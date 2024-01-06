package com.example.universalgeomanager.universalLocation

import android.location.Location


interface LocationProviderClient {
    fun getLastLocation(): TaskWrapper<Location>

    fun requestLocationUpdates(request: LocationRequest): TaskWrapper<Any>

    //TODO Add return type LocationCallback or LocationListener
    //only for now, later add overrides
    fun removeLocationUpdates()

    //TODO Add return type LocationAvailability
    fun getLocationAvailability()
}
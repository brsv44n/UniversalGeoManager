package com.example.universalgeomanager.universalLocation

import android.location.Location
import android.os.Looper
import com.example.universalgeomanager.universalLocation.location.LocationAvailability
import com.example.universalgeomanager.universalLocation.location.LocationCallback

interface LocationProviderClient {
    fun getLastLocation(): TaskWrapper<Location>
    fun requestLocationUpdates(request: LocationRequest, locationCallback: LocationCallback, looper: Looper?): TaskWrapper<Any>
    fun removeLocationUpdates(locationCallback: LocationCallback)
    fun getLocationAvailability(): TaskWrapper<LocationAvailability>
    fun flushLocations(): TaskWrapper<Any>
}
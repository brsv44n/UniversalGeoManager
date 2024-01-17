package com.example.universalgeomanager.universalLocation

import android.location.Location
import android.os.Looper
import com.example.universalgeomanager.universalLocation.location.LocationAvailability
import com.example.universalgeomanager.universalLocation.location.LocationCallback


interface LocationProviderClient {

    fun getLastLocation(): TaskWrapper<Location>

    fun requestLocationUpdates(request: LocationRequest, locationCallback: LocationCallback, looper: Looper?): TaskWrapper<Any>

    //TODO add requestLocationUpdates(LocationRequest, PendingIntent): TaskWrapper<Any>

    fun removeLocationUpdates(locationCallback: LocationCallback)

    //TODO add removeLocationUpdates(PendingIntent)

    fun getLocationAvailability(): TaskWrapper<LocationAvailability>
}
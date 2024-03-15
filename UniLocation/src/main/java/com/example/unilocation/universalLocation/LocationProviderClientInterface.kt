package com.example.unilocation.universalLocation

import android.location.Location
import android.os.Looper
import com.example.unilocation.universalLocation.location.LocationAvailability
import com.example.unilocation.universalLocation.location.LocationCallback

interface LocationProviderClient {
    fun getLastLocation(): TaskWrapper<Location>
    fun requestLocationUpdates(request: LocationRequest, locationCallback: LocationCallback, looper: Looper?): TaskWrapper<Any>
    fun removeLocationUpdates(locationCallback: LocationCallback)
    fun getLocationAvailability(): TaskWrapper<LocationAvailability>
    fun flushLocations(): TaskWrapper<Any>
}
package com.example.universalgeomanager.universalLocation

import android.location.Location
import android.os.Looper
import com.google.android.gms.location.LocationCallback


interface LocationProviderClient {
    fun getLastLocation(): TaskWrapper<Location>

    fun requestLocationUpdates(request: LocationRequest, locationListener: LocationCallback, looper: Looper): TaskWrapper<Any>

    //TODO Add return type LocationCallback or LocationListener
    //only for now, later add overrides
    fun removeLocationUpdates()

    //TODO Add return type LocationAvailability
    fun getLocationAvailability()
}
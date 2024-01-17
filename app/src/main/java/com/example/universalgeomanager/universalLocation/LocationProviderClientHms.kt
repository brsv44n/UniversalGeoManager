package com.example.universalgeomanager.universalLocation

import android.content.Context
import android.location.Location
import android.os.Looper
import com.example.universalgeomanager.universalLocation.location.LocationAvailability
import com.example.universalgeomanager.universalLocation.location.LocationCallback
import com.huawei.hms.location.FusedLocationProviderClient
import com.huawei.hms.location.LocationServices

class LocationProviderClientHms(private val context: Context): LocationProviderClient {

    private val locationProvider: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    override fun getLastLocation(): TaskWrapper<Location> =
        TaskWrapperHms(locationProvider.lastLocation)

    override fun requestLocationUpdates(
        request: LocationRequest,
        locationCallback: LocationCallback,
        looper: Looper?
    ): TaskWrapper<Any> {
        TODO("Not yet implemented")
    }

    override fun removeLocationUpdates(locationCallback: LocationCallback) {
        TODO("Not yet implemented")
    }

    override fun getLocationAvailability(): TaskWrapper<LocationAvailability> {
        TODO("Not yet implemented")
    }

}
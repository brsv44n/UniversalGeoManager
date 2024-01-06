package com.example.universalgeomanager.universalLocation

import android.content.Context
import android.location.Location
import com.huawei.hms.location.FusedLocationProviderClient
import com.huawei.hms.location.LocationServices

class LocationProviderClientHms(private val context: Context): LocationProviderClient {

    private val locationProvider: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    override fun getLastLocation(): TaskWrapper<Location> = TaskWrapperHms(locationProvider.lastLocation)

    override fun requestLocationUpdates(request: LocationRequest): TaskWrapper<Any> {
        TODO("Not yet implemented")
    }

    override fun removeLocationUpdates() {
        TODO("Not yet implemented")
    }

    override fun getLocationAvailability() {
        TODO("Not yet implemented")
    }
}
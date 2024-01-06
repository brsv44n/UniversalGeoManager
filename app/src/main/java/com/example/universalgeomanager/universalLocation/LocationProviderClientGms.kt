package com.example.universalgeomanager.universalLocation

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

@SuppressLint("MissingPermission")
class LocationProviderClientGms(private val context: Context): LocationProviderClient {

    private val locationProvider: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    override fun getLastLocation(): TaskWrapper<Location> = TaskWrapperGms(locationProvider.lastLocation)
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
package com.example.unilocation.universalLocation.location

import android.location.Location

class LocationResultGms(
    private val locationResult: com.google.android.gms.location.LocationResult
) : LocationResult {

    override fun getLastLocation(): Location? {
        return locationResult.lastLocation
    }

    override fun getLocations(): List<Location> {
        return locationResult.locations
    }
}
package com.example.unilocation.universalLocation.location.gms

import android.location.Location
import com.example.unilocation.universalLocation.location.LocationResult

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
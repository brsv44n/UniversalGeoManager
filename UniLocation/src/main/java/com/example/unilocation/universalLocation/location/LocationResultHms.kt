package com.example.unilocation.universalLocation.location

import android.location.Location

class LocationResultHms(
    private val locationResult: com.huawei.hms.location.LocationResult
) : LocationResult {

    override fun getLastLocation(): Location? {
        return locationResult.lastLocation
    }

    override fun getLocations(): List<Location> {
        return locationResult.locations
    }
}
package com.example.unilocation.universalLocation.location.hms

import android.location.Location
import com.example.unilocation.universalLocation.location.LocationResult

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
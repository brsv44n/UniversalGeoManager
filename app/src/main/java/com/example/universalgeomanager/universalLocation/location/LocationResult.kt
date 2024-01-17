package com.example.universalgeomanager.universalLocation.location

import android.location.Location

interface LocationResult {

    fun getLastLocation(): Location?

    fun getLocations(): List<Location>
}

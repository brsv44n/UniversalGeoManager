package com.example.universalgeomanager.universalLocation.location

interface LocationCallback {

    fun onLocationAvailability(availability: LocationAvailability)

    fun onLocationResult(result: LocationResult)
}
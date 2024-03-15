package com.example.unilocation.universalLocation.location

interface LocationCallback {

    fun onLocationAvailability(availability: LocationAvailability)

    fun onLocationResult(result: LocationResult)
}
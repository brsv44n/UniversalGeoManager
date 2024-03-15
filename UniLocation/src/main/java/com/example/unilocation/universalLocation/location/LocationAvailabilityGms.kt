package com.example.unilocation.universalLocation.location

class LocationAvailabilityGms(
    private val locationAvailability: com.google.android.gms.location.LocationAvailability
) : LocationAvailability {
    override fun isLocationAvailable(): Boolean = locationAvailability.isLocationAvailable
}
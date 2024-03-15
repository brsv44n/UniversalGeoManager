package com.example.unilocation.universalLocation.location

class LocationAvailabilityHms(
    private val locationAvailability: com.huawei.hms.location.LocationAvailability
) : LocationAvailability {
    override fun isLocationAvailable(): Boolean = locationAvailability.isLocationAvailable
}
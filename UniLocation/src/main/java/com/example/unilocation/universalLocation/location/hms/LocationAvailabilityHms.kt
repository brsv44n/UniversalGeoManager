package com.example.unilocation.universalLocation.location.hms

import com.example.unilocation.universalLocation.location.LocationAvailability

class LocationAvailabilityHms(
    private val locationAvailability: com.huawei.hms.location.LocationAvailability
) : LocationAvailability {
    override fun isLocationAvailable(): Boolean = locationAvailability.isLocationAvailable
}
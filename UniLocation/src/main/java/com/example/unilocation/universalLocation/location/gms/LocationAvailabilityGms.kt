package com.example.unilocation.universalLocation.location.gms

import com.example.unilocation.universalLocation.location.LocationAvailability

class LocationAvailabilityGms(
    private val locationAvailability: com.google.android.gms.location.LocationAvailability
) : LocationAvailability {
    override fun isLocationAvailable(): Boolean = locationAvailability.isLocationAvailable

    override fun getLocationStatus(): Int {
        throw UnsupportedOperationException("Location status is not supported on this device.")
    }

    override fun getCellStatus(): Int {
        throw UnsupportedOperationException("Cell status is not supported on this device.")
    }

    override fun getWifiStatus(): Int {
        throw UnsupportedOperationException("Wifi status is not supported on this device.")
    }

    override fun setLocationStatus(status: Int) {
        throw UnsupportedOperationException("Location status is not supported on this device.")
    }
}
package com.example.unilocation.universalLocation.location.hms

import com.example.unilocation.universalLocation.location.LocationAvailability

class LocationAvailabilityHms(
    private val locationAvailability: com.huawei.hms.location.LocationAvailability
) : LocationAvailability {

    override fun isLocationAvailable(): Boolean = locationAvailability.isLocationAvailable

    override fun getLocationStatus(): Int = locationAvailability.locationStatus

    override fun getCellStatus(): Int = locationAvailability.cellStatus

    override fun getWifiStatus(): Int = locationAvailability.wifiStatus

    override fun setLocationStatus(status: Int) {
        locationAvailability.locationStatus = status
    }

}
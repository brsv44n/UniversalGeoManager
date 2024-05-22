package com.example.unilocation.universalLocation.location

interface LocationAvailability {

    fun isLocationAvailable(): Boolean

    fun getLocationStatus(): Int

    fun getCellStatus(): Int

    fun getWifiStatus(): Int

    fun setLocationStatus(status: Int)
}
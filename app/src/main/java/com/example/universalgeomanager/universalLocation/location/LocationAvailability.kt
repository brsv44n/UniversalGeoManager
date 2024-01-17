package com.example.universalgeomanager.universalLocation.location

interface LocationAvailability {

    fun isLocationAvailable(): Boolean

    //TODO у HMS есть getCellStatus/getWifiStatus/etc, возможно стоит добавить, а гуглу оставить какое-то дефолтное значение типа UNKNOWN
}

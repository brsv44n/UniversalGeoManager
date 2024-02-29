package com.example.universalgeomanager.universalLocation.settingsClient

import com.example.universalgeomanager.universalLocation.LocationRequest

class LocationSettingsRequest private constructor(){

    companion object {
        fun create(): LocationSettingsRequest = LocationSettingsRequest()
    }

    val locationRequests: MutableList<LocationRequest> = mutableListOf()

    var alwaysShow: Boolean? = null
        private set

    var needBle: Boolean? = null
        private set

    fun addAllLocationRequests(requests: Collection<LocationRequest>) {
        this.locationRequests.addAll(requests)
    }

    fun addLocationRequest(request: LocationRequest) {
        this.locationRequests.add(request)
    }

    fun setAlwaysShow(show: Boolean) {
        this.alwaysShow = show
    }

    fun setNeedBle(needBle: Boolean) {
        this.needBle = needBle
    }

}
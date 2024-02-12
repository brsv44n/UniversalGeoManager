package com.example.universalgeomanager.universalLocation.settingsClient

import com.example.universalgeomanager.universalLocation.LocationRequest

interface LocationSettingsRequest {
    fun Builder(){
        fun addAllLocationRequests(requests: Collection<LocationRequest> ) {}
        fun addLocationRequest(request: LocationRequest){}
    }
}
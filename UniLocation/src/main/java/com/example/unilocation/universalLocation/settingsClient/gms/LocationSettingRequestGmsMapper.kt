package com.example.unilocation.universalLocation.settingsClient.gms

import com.example.unilocation.universalLocation.gms.LocationRequestGmsMapper
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsRequest

class LocationSettingRequestGmsMapper {

    fun createLocationSettingsRequest(
        request: LocationSettingsRequest
    ): com.google.android.gms.location.LocationSettingsRequest {

        val builder = com.google.android.gms.location.LocationSettingsRequest.Builder()
        val locationRequestMapper = LocationRequestGmsMapper()

        if (request.locationRequests.size == 1) builder.addLocationRequest(
            locationRequestMapper.createGmsLocationRequest(request.locationRequests[0])
        ) else if (request.locationRequests.size > 1) {

            val tobeAdded = mutableListOf<com.google.android.gms.location.LocationRequest>()
            request.locationRequests.forEach {
                tobeAdded.add(locationRequestMapper.createGmsLocationRequest(it))
            }
            builder.addAllLocationRequests(tobeAdded)

        }

        request.alwaysShow?.let { builder.setAlwaysShow(it) }
        request.needBle?.let { builder.setNeedBle(it) }

        return builder.build()
    }

}
package com.example.unilocation.universalLocation.settingsClient.hms

import com.example.unilocation.universalLocation.hms.LocationRequestHmsMapper
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsRequest

class LocationSettingRequestHmsMapper {

    fun createLocationSettingsRequest(
        request: LocationSettingsRequest
    ): com.huawei.hms.location.LocationSettingsRequest {

        val builder = com.huawei.hms.location.LocationSettingsRequest.Builder()
        val locationRequestMapper = LocationRequestHmsMapper()

        if (request.locationRequests.size == 1) builder.addLocationRequest(
            locationRequestMapper.createHmsLocationRequest(request.locationRequests[0])
        ) else if (request.locationRequests.size > 1) {

            val tobeAdded = mutableListOf<com.huawei.hms.location.LocationRequest>()
            request.locationRequests.forEach {
                tobeAdded.add(locationRequestMapper.createHmsLocationRequest(it))
            }
            builder.addAllLocationRequests(tobeAdded)

        }

        request.alwaysShow?.let { builder.setAlwaysShow(it) }
        request.needBle?.let { builder.setNeedBle(it) }

        return builder.build()
    }

}
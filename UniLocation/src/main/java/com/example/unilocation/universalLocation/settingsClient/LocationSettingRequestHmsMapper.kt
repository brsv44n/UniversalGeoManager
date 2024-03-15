package com.example.unilocation.universalLocation.settingsClient

import com.example.unilocation.universalLocation.LocationRequestHmsMapper

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

        if (request.alwaysShow != null) builder.setAlwaysShow(request.alwaysShow!!)
        if (request.needBle != null) builder.setNeedBle(request.needBle!!)

        return builder.build()
    }

}
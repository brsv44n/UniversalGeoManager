package com.example.unilocation.universalLocation.settingsClient

import com.example.unilocation.universalLocation.LocationRequestGmsMapper

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

        /**
         * TODO просто для информации:
         * можно request.alwaysShow?.let { builder.setAlwaysShow(it) }
         * force unwrap лучше не использовать, т.к. это может привести к NPE (в этом случае конечно нет), да и в целом некрасиво :)
         */
        if (request.alwaysShow != null) builder.setAlwaysShow(request.alwaysShow!!)
        if (request.needBle != null) builder.setNeedBle(request.needBle!!)

        return builder.build()
    }

}
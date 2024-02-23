package com.example.universalgeomanager.universalGeofence

class GeofenceRequestHmsMapper {
    fun createGeofenceRequestGms(request: GeofenceRequest): com.huawei.hms.location.GeofenceRequest {

        val builder = com.huawei.hms.location.GeofenceRequest.Builder()
        val geofenceMapper = GeofenceMapperHms()

        when (request.initialTrigger){
            GeofenceRequest.INITIAL_TRIGGER_DWELL -> builder.setInitConversions(com.huawei.hms.location.GeofenceRequest.DWELL_INIT_CONVERSION)
            GeofenceRequest.INITIAL_TRIGGER_ENTER -> builder.setInitConversions(com.huawei.hms.location.GeofenceRequest.ENTER_INIT_CONVERSION)
            GeofenceRequest.INITIAL_TRIGGER_EXIT -> builder.setInitConversions(com.huawei.hms.location.GeofenceRequest.EXIT_INIT_CONVERSION)
        }

        if (request.geofences?.size == 1) builder.createGeofence(
            geofenceMapper.createGeofence(request.geofences!![0])
        ) else if (request.geofences?.size!! > 1) {

            val tobeAdded = mutableListOf<com.huawei.hms.location.Geofence>()
            request.geofences!!.forEach {
                tobeAdded.add(geofenceMapper.createGeofence(it))
            }
            builder.createGeofenceList(tobeAdded)
        }

        return builder.build()

    }

}
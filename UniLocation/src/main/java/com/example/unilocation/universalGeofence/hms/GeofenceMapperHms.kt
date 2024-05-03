package com.example.unilocation.universalGeofence.hms

import com.example.unilocation.universalGeofence.Geofence

class GeofenceMapperHms {

    fun createGeofence(geofence: Geofence): com.huawei.hms.location.Geofence {
        val builder = com.huawei.hms.location.Geofence.Builder()

        when (geofence.transitionsType){
            Geofence.GEOFENCE_TRANSITION_DWELL -> builder.setConversions(com.huawei.hms.location.Geofence.DWELL_GEOFENCE_CONVERSION)
            Geofence.GEOFENCE_TRANSITION_ENTER -> builder.setConversions(com.huawei.hms.location.Geofence.ENTER_GEOFENCE_CONVERSION)
            Geofence.GEOFENCE_TRANSITION_EXIT -> builder.setConversions(com.huawei.hms.location.Geofence.EXIT_GEOFENCE_CONVERSION)
            Geofence.NEVER_EXPIRE.toInt() -> builder.setConversions(com.huawei.hms.location.Geofence.GEOFENCE_NEVER_EXPIRE.toInt())
        }

        geofence.notificationResponsiveness?.let { builder.setNotificationInterval(it)}
        geofence.expirationTime?.let { builder.setValidContinueTime(it)}
        geofence.loiteringDelay?.let { builder.setDwellDelayTime(it)}
        geofence.requestedId?.let { builder.setUniqueId(it)}

        if (
            geofence.longitude != null &&
            geofence.latitude != null &&
            geofence.radius != null
        ) {
            builder.setRoundArea(geofence.latitude!!, geofence.longitude!!, geofence.radius!!)
        }

        return builder.build()
    }

}
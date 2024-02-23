package com.example.universalgeomanager.universalGeofence

class GeofenceMapperHms {

    fun createGeofence(geofence: Geofence): com.huawei.hms.location.Geofence {
        val builder = com.huawei.hms.location.Geofence.Builder()

        when (geofence.transitionsType){
            Geofence.GEOFENCE_TRANSITION_DWELL -> builder.setConversions(com.huawei.hms.location.Geofence.DWELL_GEOFENCE_CONVERSION)
            Geofence.GEOFENCE_TRANSITION_ENTER -> builder.setConversions(com.huawei.hms.location.Geofence.ENTER_GEOFENCE_CONVERSION)
            Geofence.GEOFENCE_TRANSITION_EXIT -> builder.setConversions(com.huawei.hms.location.Geofence.EXIT_GEOFENCE_CONVERSION)
            Geofence.NEVER_EXPIRE.toInt() -> builder.setConversions(com.huawei.hms.location.Geofence.GEOFENCE_NEVER_EXPIRE.toInt())
        }

        if (geofence.notificationResponsiveness != null) builder.setNotificationInterval(geofence.notificationResponsiveness!!)
        if (geofence.expirationTime != null) builder.setValidContinueTime(geofence.expirationTime!!)
        if (geofence.loiteringDelay != null) builder.setDwellDelayTime(geofence.loiteringDelay!!)
        if (geofence.requestedId != null) builder.setUniqueId(geofence.requestedId!!)

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
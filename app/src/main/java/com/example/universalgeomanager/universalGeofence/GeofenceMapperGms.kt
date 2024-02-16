package com.example.universalgeomanager.universalGeofence

class GeofenceMapperGms {
    fun createGeofence(geofence: Geofence): com.google.android.gms.location.Geofence {

        val builder = com.google.android.gms.location.Geofence.Builder()

        if (geofence.expirationTime != null) builder.setExpirationDuration(geofence.expirationTime!!)
        if (geofence.loiteringDelay != null) builder.setLoiteringDelay(geofence.loiteringDelay!!)
        if (geofence.notificationResponsiveness != null) builder.setNotificationResponsiveness(geofence.notificationResponsiveness!!)
        if (geofence.requestedId != null) builder.setRequestId(geofence.requestedId!!)
        if (geofence.transitionsType != null) builder.setTransitionTypes(geofence.transitionsType!!)

        return builder.build()
    }


}
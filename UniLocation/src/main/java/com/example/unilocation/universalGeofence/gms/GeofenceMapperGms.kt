package com.example.unilocation.universalGeofence.gms

import com.example.unilocation.universalGeofence.Geofence
import com.example.unilocation.universalGeofence.Geofence.Companion.GEOFENCE_TRANSITION_DWELL
import com.example.unilocation.universalGeofence.Geofence.Companion.GEOFENCE_TRANSITION_ENTER
import com.example.unilocation.universalGeofence.Geofence.Companion.GEOFENCE_TRANSITION_EXIT
import com.example.unilocation.universalGeofence.Geofence.Companion.NEVER_EXPIRE

class GeofenceMapperGms {
    fun createGeofence(geofence: Geofence): com.google.android.gms.location.Geofence {

        val builder = com.google.android.gms.location.Geofence.Builder()

        when (geofence.transitionsType){
            GEOFENCE_TRANSITION_DWELL -> builder.setTransitionTypes(com.google.android.gms.location.Geofence.GEOFENCE_TRANSITION_DWELL)
            GEOFENCE_TRANSITION_ENTER -> builder.setTransitionTypes(com.google.android.gms.location.Geofence.GEOFENCE_TRANSITION_ENTER)
            GEOFENCE_TRANSITION_EXIT -> builder.setTransitionTypes(com.google.android.gms.location.Geofence.GEOFENCE_TRANSITION_EXIT)
            NEVER_EXPIRE.toInt() -> builder.setTransitionTypes(com.google.android.gms.location.Geofence.NEVER_EXPIRE.toInt())
        }

        geofence.expirationTime?.let { builder.setExpirationDuration(it) }
        geofence.loiteringDelay?.let { builder.setLoiteringDelay(it) }
        geofence.notificationResponsiveness?.let { builder.setNotificationResponsiveness(it) }
        geofence.requestedId?.let { builder.setRequestId(it) }

        if (
            geofence.longitude != null &&
            geofence.latitude != null &&
            geofence.radius != null
        ) {
            builder.setCircularRegion(geofence.latitude!!, geofence.longitude!!, geofence.radius!!)
        }

        return builder.build()
    }

}
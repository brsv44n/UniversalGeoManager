package com.example.unilocation.universalGeofence.gms

import com.example.unilocation.universalGeofence.UGeofenceEvent

class UGeofenceEventMapperGms {
    fun createUGeofenceEvent(geofenceEvent: com.google.android.gms.location.GeofencingEvent): UGeofenceEvent {
        val geofenceMapper = GeofenceMapperGms()
        return UGeofenceEvent.create().apply {
            setErrorCode(geofenceEvent.errorCode)
            setGeofenceTransition(geofenceEvent.geofenceTransition)
            setErrorExistence(geofenceEvent.hasError())
            geofenceEvent.triggeringLocation?.let { setTriggeringLocation(it) }
            //TODO("Понять как маппить Geofence из gms в обертку и надо ли оно")
        }
    }
}
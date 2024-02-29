package com.example.universalgeomanager.universalGeofence

import com.example.universalgeomanager.universalGeofence.GeofenceRequest.Companion.INITIAL_TRIGGER_DWELL
import com.example.universalgeomanager.universalGeofence.GeofenceRequest.Companion.INITIAL_TRIGGER_ENTER
import com.example.universalgeomanager.universalGeofence.GeofenceRequest.Companion.INITIAL_TRIGGER_EXIT

class GeofenceRequestGmsMapper {
    fun createGeofenceRequestGms(request: GeofenceRequest): com.google.android.gms.location.GeofencingRequest {
        val builder = com.google.android.gms.location.GeofencingRequest.Builder()
        val geofenceMapper = GeofenceMapperGms()

        when (request.initialTrigger){
            INITIAL_TRIGGER_DWELL -> builder.setInitialTrigger(com.google.android.gms.location.GeofencingRequest.INITIAL_TRIGGER_DWELL)
            INITIAL_TRIGGER_ENTER -> builder.setInitialTrigger(com.google.android.gms.location.GeofencingRequest.INITIAL_TRIGGER_ENTER)
            INITIAL_TRIGGER_EXIT -> builder.setInitialTrigger(com.google.android.gms.location.GeofencingRequest.INITIAL_TRIGGER_EXIT)
        }

        if (request.geofences.size == 1) builder.addGeofence(
            geofenceMapper.createGeofence(request.geofences[0])
        ) else if (request.geofences.size > 1) {

            val tobeAdded = mutableListOf<com.google.android.gms.location.Geofence>()
            request.geofences.forEach {
                tobeAdded.add(geofenceMapper.createGeofence(it))
            }
            builder.addGeofences(tobeAdded)
        }

        return builder.build()
    }
}
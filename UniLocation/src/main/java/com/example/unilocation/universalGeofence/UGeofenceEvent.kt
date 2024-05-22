package com.example.unilocation.universalGeofence

import android.location.Location

class UGeofenceEvent {
    companion object {
        fun create() = UGeofenceEvent()
    }
    var errorCode: Int? = null
        private set

    var geofenceTransition: Int? = null
        private set

    val triggeringGeofences: MutableList<Geofence> = mutableListOf()

    var triggeringLocation: Location? = null
        private set

    var hasError: Boolean? = null
    fun setErrorCode(errorCode: Int){
        this.errorCode = errorCode
    }

    fun setGeofenceTransition(geofenceTransition: Int){
        this.geofenceTransition = geofenceTransition
    }

    fun addTriggeringGeofence(geofence: Geofence) {
        triggeringGeofences.add(geofence)
    }

    fun setTriggeringLocation(location: Location){
        triggeringLocation = location
    }

    fun setErrorExistence(hasError: Boolean) {
        this.hasError = hasError
    }

}
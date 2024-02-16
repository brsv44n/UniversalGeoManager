package com.example.universalgeomanager.universalGeofence

class GeofenceRequest private constructor() {
    companion object {
        const val INITIAL_TRIGGER_DWELL: Int = 4
        const val INITIAL_TRIGGER_ENTER: Int = 1
        const val INITIAL_TRIGGER_EXIT: Int = 2
    }

    fun getGeofences(): List<Geofence> {
        TODO()
    }

}
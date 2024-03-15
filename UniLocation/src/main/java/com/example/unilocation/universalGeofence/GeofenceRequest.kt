package com.example.unilocation.universalGeofence

class GeofenceRequest private constructor() {
    companion object {
        const val INITIAL_TRIGGER_DWELL: Int = 4
        const val INITIAL_TRIGGER_ENTER: Int = 1
        const val INITIAL_TRIGGER_EXIT: Int = 2

        fun create(): GeofenceRequest = GeofenceRequest()
    }

    var geofences: MutableList<Geofence> = mutableListOf()

    var initialTrigger: Int? = null
        private set

    fun setInitialTrigger(initialTrigger: Int){
        this.initialTrigger = initialTrigger
    }

    fun addGeofence(geofence: Geofence){
        this.geofences.add(geofence)
    }

    fun addGeofences(geofences: Collection<Geofence>){
        this.geofences.addAll(geofences)
    }

}
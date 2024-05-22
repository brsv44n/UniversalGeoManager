package com.example.unilocation.universalGeofence

class Geofence private constructor() {
    companion object {
        const val GEOFENCE_TRANSITION_DWELL: Int = 4
        const val GEOFENCE_TRANSITION_ENTER: Int = 1
        const val GEOFENCE_TRANSITION_EXIT: Int = 2
        const val NEVER_EXPIRE : Long = -1

        fun create() : Geofence = Geofence()
    }

    var expirationTime: Long? = null
        private set

    var latitude: Double? = null
        private set

    var loiteringDelay: Int? = null
        private set

    var longitude: Double? = null
        private set

    var notificationResponsiveness: Int? = null
        private set

    var radius: Float? = null
        private set

    var requestedId: String? = null
        private set

    var transitionsType: Int? = null
        private set

    fun setExpirationDuration(durationMillis: Long){
        this.expirationTime = durationMillis
    }

    fun setLoiteringDelay(loiteringDelayMs: Int){
        this.loiteringDelay = loiteringDelayMs
    }

    fun setNotificationResponsiveness(notificationResponsivenessMs: Int){
        this.notificationResponsiveness = notificationResponsivenessMs
    }

    fun setRequestId(requestId: String){
        this.requestedId = requestId
    }

    fun setTransitionTypes(transitionTypes: Int){
        this.transitionsType = transitionTypes
    }

    fun setCircularRegion(latitude: Double, longitude: Double, radius: Float) {
        this.latitude = latitude
        this.longitude = longitude
        this.radius = radius
    }
}
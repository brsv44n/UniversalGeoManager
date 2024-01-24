package com.example.universalgeomanager.universalLocation

class LocationRequest private constructor() {
    companion object {
        const val PRIORITY_BALANCED_POWER_ACCURACY = 102
        const val PRIORITY_HIGH_ACCURACY = 100
        const val PRIORITY_LOW_POWER = 104
        const val PRIORITY_PASSIVE = 105
        const val PRIORITY_HD_ACCURACY = 200
        fun create(): LocationRequest = LocationRequest()
    }

    var priority: Int? = null
        private set
    var expirationDuration: Long? = null
        private set
    var expirationTime: Long? = null
        private set
    var fastestInterval: Long? = null
        private set
    var interval: Long? = null
        private set
    var maxWaitTime: Long? = null
        private set
    var numUpdates: Int? = null
        private set
    var smallestDisplacement: Float? = null
        private set

    fun setPriority(priority: Int) {
        this.priority = priority
    }
    fun setExpirationDuration(durationMillis: Long){
        this.expirationDuration = durationMillis
    }
    fun setExpirationTime(elapsedRealtime: Long){
        this.expirationTime = elapsedRealtime
    }
    fun setFastestInterval(fastestIntervalMillis: Long){
        this.fastestInterval = fastestIntervalMillis
    }
    fun setInterval(intervalMillis: Long){
        this.interval = intervalMillis
    }
    fun setMaxWaitTime(maxWaitTimeMillis: Long){
        this.maxWaitTime = maxWaitTimeMillis
    }
    fun setNumUpdates(numUpdates: Int){
        this.numUpdates = numUpdates
    }
    fun setSmallestDisplacement(smallestDisplacementMeters: Float){
        this.smallestDisplacement = smallestDisplacementMeters
    }
}
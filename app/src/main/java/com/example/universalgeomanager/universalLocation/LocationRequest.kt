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

    val gmsLocationRequest = com.google.android.gms.location.LocationRequest.create()
    val hmsLocationRequest = com.huawei.hms.location.LocationRequest.create()

    fun setPriority(priority: Int) {
        when (priority) {
            PRIORITY_HIGH_ACCURACY -> {
                gmsLocationRequest.priority = com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY
                hmsLocationRequest.setPriority(PRIORITY_HIGH_ACCURACY)
            }
            PRIORITY_BALANCED_POWER_ACCURACY -> {
                gmsLocationRequest.priority = com.google.android.gms.location.Priority.PRIORITY_BALANCED_POWER_ACCURACY
                hmsLocationRequest.setPriority(PRIORITY_BALANCED_POWER_ACCURACY)
            }
            PRIORITY_LOW_POWER -> {
                gmsLocationRequest.priority = com.google.android.gms.location.Priority.PRIORITY_LOW_POWER
                hmsLocationRequest.setPriority(PRIORITY_LOW_POWER)
            }
            PRIORITY_PASSIVE -> {
                gmsLocationRequest.priority = com.google.android.gms.location.Priority.PRIORITY_PASSIVE
                hmsLocationRequest.setPriority(PRIORITY_PASSIVE) //PRIORITY_NO_POWER
            }

            //Only in HMS
            PRIORITY_HD_ACCURACY -> {
                hmsLocationRequest.setPriority(PRIORITY_HD_ACCURACY)
            }
        }
    }
}
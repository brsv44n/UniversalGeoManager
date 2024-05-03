package com.example.unilocation.universalLocation.gms

import com.example.unilocation.universalLocation.LocationRequest
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_BALANCED_POWER_ACCURACY
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_HIGH_ACCURACY
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_LOW_POWER
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_PASSIVE

class LocationRequestGmsMapper {
    fun createGmsLocationRequest(request: LocationRequest): com.google.android.gms.location.LocationRequest =
        com.google.android.gms.location.LocationRequest.create().apply {
            
            priority = when (request.priority) {
                PRIORITY_HIGH_ACCURACY -> com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY
                PRIORITY_BALANCED_POWER_ACCURACY -> com.google.android.gms.location.Priority.PRIORITY_BALANCED_POWER_ACCURACY
                PRIORITY_LOW_POWER -> com.google.android.gms.location.Priority.PRIORITY_LOW_POWER
                PRIORITY_PASSIVE -> com.google.android.gms.location.Priority.PRIORITY_PASSIVE
                else -> com.google.android.gms.location.Priority.PRIORITY_BALANCED_POWER_ACCURACY
            }

            request.expirationTime?.let { expirationTime = it }
            request.expirationDuration?.let { setExpirationDuration(it) }
            request.fastestInterval?.let { fastestInterval = it }
            request.interval?.let { interval = it }
            request.maxWaitTime?.let { maxWaitTime = it }
            request.numUpdates?.let { numUpdates = it }
            request.smallestDisplacement?.let { smallestDisplacement = it }

        }

}
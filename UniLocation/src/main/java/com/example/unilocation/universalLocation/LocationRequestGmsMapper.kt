package com.example.unilocation.universalLocation

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

            if (request.expirationTime != null) { expirationTime = request.expirationTime!! }

            if (request.expirationDuration != null) { setExpirationDuration(request.expirationDuration!!) }

            if (request.fastestInterval != null) { fastestInterval = request.fastestInterval!! }

            if (request.interval != null) { interval = request.interval!! }

            if (request.maxWaitTime != null) { maxWaitTime = request.maxWaitTime!! }

            if (request.numUpdates != null) { numUpdates = request.numUpdates!! }

            if (request.smallestDisplacement != null) { smallestDisplacement = request.smallestDisplacement!! }

        }

}
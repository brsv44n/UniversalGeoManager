package com.example.universalgeomanager.universalLocation

import com.example.universalgeomanager.universalLocation.LocationRequest.Companion.PRIORITY_BALANCED_POWER_ACCURACY
import com.example.universalgeomanager.universalLocation.LocationRequest.Companion.PRIORITY_HIGH_ACCURACY
import com.example.universalgeomanager.universalLocation.LocationRequest.Companion.PRIORITY_LOW_POWER
import com.example.universalgeomanager.universalLocation.LocationRequest.Companion.PRIORITY_PASSIVE

class LocationRequestGmsMapper {
    fun createGmsLocationRequest(request: LocationRequest): com.google.android.gms.location.LocationRequest =
        com.google.android.gms.location.LocationRequest.create().let { gmsRequest ->
            request.priority.let { priority ->
                val gmsPriority = when (priority) {
                    PRIORITY_HIGH_ACCURACY -> com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY
                    PRIORITY_BALANCED_POWER_ACCURACY -> com.google.android.gms.location.Priority.PRIORITY_BALANCED_POWER_ACCURACY
                    PRIORITY_LOW_POWER -> com.google.android.gms.location.Priority.PRIORITY_LOW_POWER
                    PRIORITY_PASSIVE -> com.google.android.gms.location.Priority.PRIORITY_PASSIVE
                    else -> com.google.android.gms.location.Priority.PRIORITY_BALANCED_POWER_ACCURACY
                }
                gmsRequest.setPriority(gmsPriority)
            }
            request.expirationDuration!!.let { durationTimeMillis ->
                gmsRequest.setExpirationDuration(durationTimeMillis)
            }
            request.expirationTime!!.let { expirationTimeMillis ->
                gmsRequest.setExpirationTime(expirationTimeMillis)
            }
            request.fastestInterval!!.let { fastestIntervalMillis ->
                gmsRequest.setFastestInterval(fastestIntervalMillis)
            }
            request.interval!!.let { interval ->
                gmsRequest.setInterval(interval)
            }
            request.maxWaitTime!!.let { maxWaitTimeMillis ->
                gmsRequest.setMaxWaitTime(maxWaitTimeMillis)
            }
            request.numUpdates!!.let { numUpdates ->
                gmsRequest.setNumUpdates(numUpdates)
            }
            request.smallestDisplacement!!.let { smallestDisplacementMeters ->
                gmsRequest.setSmallestDisplacement(smallestDisplacementMeters)
            }
        }
}
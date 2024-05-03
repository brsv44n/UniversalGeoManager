package com.example.unilocation.universalLocation.hms

import com.example.unilocation.universalLocation.LocationRequest
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_BALANCED_POWER_ACCURACY
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_HD_ACCURACY
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_HIGH_ACCURACY
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_LOW_POWER
import com.example.unilocation.universalLocation.LocationRequest.Companion.PRIORITY_PASSIVE

class LocationRequestHmsMapper {
    fun createHmsLocationRequest(request: LocationRequest): com.huawei.hms.location.LocationRequest =
        com.huawei.hms.location.LocationRequest.create().let { hmsRequest ->
            request.priority.let { priority ->
                val hmsPriority = when (priority) {
                    PRIORITY_HIGH_ACCURACY -> com.huawei.hms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
                    PRIORITY_BALANCED_POWER_ACCURACY -> com.huawei.hms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
                    PRIORITY_LOW_POWER -> com.huawei.hms.location.LocationRequest.PRIORITY_LOW_POWER
                    PRIORITY_PASSIVE -> com.huawei.hms.location.LocationRequest.PRIORITY_NO_POWER
                    PRIORITY_HD_ACCURACY -> com.huawei.hms.location.LocationRequest.PRIORITY_HD_ACCURACY
                    else -> com.huawei.hms.location.LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
                }
                hmsRequest.setPriority(hmsPriority)
            }

            /*
            request.expirationTime?.let { expirationTime = it }
            request.expirationDuration?.let { setExpirationDuration(it) }
            request.fastestInterval?.let { fastestInterval = it }
            request.interval?.let { interval = it }
            request.maxWaitTime?.let { maxWaitTime = it }
            request.numUpdates?.let { numUpdates = it }
            request.smallestDisplacement?.let { smallestDisplacement = it }
            */

            request.expirationDuration?.let { durationTimeMillis ->
                hmsRequest.setExpirationDuration(durationTimeMillis)
            }
            request.expirationTime?.let { expirationTimeMillis ->
                hmsRequest.setExpirationTime(expirationTimeMillis)
            }
            request.fastestInterval?.let { fastestIntervalMillis ->
                hmsRequest.setFastestInterval(fastestIntervalMillis)
            }
            request.interval?.let { interval ->
                hmsRequest.setInterval(interval)
            }
            request.maxWaitTime?.let { maxWaitTimeMillis ->
                hmsRequest.setMaxWaitTime(maxWaitTimeMillis)
            }
            request.numUpdates?.let { numUpdates ->
                hmsRequest.setNumUpdates(numUpdates)
            }
            request.smallestDisplacement!!.let { smallestDisplacementMeters ->
                hmsRequest.setSmallestDisplacement(smallestDisplacementMeters)
            }
        }
}
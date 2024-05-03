package com.example.unilocation.universalGeofence

import android.content.Context
import com.example.unilocation.universalGeofence.gms.GeofenceClientGms
import com.example.unilocation.universalGeofence.hms.GeofenceClientHms
import com.example.unilocation.utils.isGMSAvailable
import com.example.unilocation.utils.isHMSAvailable

object UniversalGeofenceService {
    fun getGeofenceClient(context: Context): GeofenceClient {
        return if (isGMSAvailable(context)) GeofenceClientGms(context)
        else if (isHMSAvailable(context)) GeofenceClientHms(context)
        else TODO("something if missing...")
    }
}
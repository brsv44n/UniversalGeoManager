package com.example.universalgeomanager.universalGeofence

import android.content.Context
import com.example.universalgeomanager.utils.isGMSAvailable
import com.example.universalgeomanager.utils.isHMSAvailable

object UniversalGeofenceService {
    fun getGeofenceClient(context: Context): GeofenceClient {
        return if (isGMSAvailable(context)) GeofenceClientGms(context)
        else if (isHMSAvailable(context)) GeofenceClientHms(context)
        else TODO("something if missing...")
    }
}
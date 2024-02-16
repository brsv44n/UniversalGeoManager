package com.example.universalgeomanager.universalGeofence

import android.app.PendingIntent
import com.example.universalgeomanager.universalLocation.TaskWrapper

interface GeofenceClient {
    fun addGeofences(request: GeofenceRequest, pendingIntent: PendingIntent): TaskWrapper<Any>

    fun removeGeofences(requestIds: List<String>): TaskWrapper<Any>

    fun removeGeofences(pendingIntent: PendingIntent): TaskWrapper<Any>
}
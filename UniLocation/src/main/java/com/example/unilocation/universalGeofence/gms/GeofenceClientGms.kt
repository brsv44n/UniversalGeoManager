package com.example.unilocation.universalGeofence.gms

import android.app.PendingIntent
import android.content.Context
import androidx.annotation.RequiresPermission
import com.example.unilocation.universalGeofence.GeofenceClient
import com.example.unilocation.universalGeofence.GeofenceRequest
import com.example.unilocation.universalLocation.TaskWrapper
import com.example.unilocation.universalLocation.gms.TaskWrapperGms
import com.google.android.gms.location.LocationServices

class GeofenceClientGms (private val context: Context): GeofenceClient {

    private val geofencingClient = LocationServices.getGeofencingClient(context)

    private val geofenceRequestGmsMapper = GeofenceRequestGmsMapper()
    @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
    override fun addGeofences(
        request: GeofenceRequest,
        pendingIntent: PendingIntent
    ): TaskWrapper<Any> {
        return TaskWrapperGms(
            geofencingClient.addGeofences(
                geofenceRequestGmsMapper.createGeofenceRequestGms(request),
                pendingIntent
            ).continueWith {  }
        )
    }

    override fun removeGeofences(requestIds: List<String>): TaskWrapper<Any> {
        return TaskWrapperGms(
            geofencingClient.removeGeofences(requestIds).continueWith {  }
        )
    }

    override fun removeGeofences(pendingIntent: PendingIntent): TaskWrapper<Any> {
        return TaskWrapperGms(
            geofencingClient.removeGeofences(pendingIntent).continueWith {  }
        )
    }
}
package com.example.unilocation.universalGeofence

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

abstract class GeofenceBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val eventGms = com.google.android.gms.location.GeofencingEvent.fromIntent(intent)
        val eventHms = com.huawei.hms.location.GeofenceData.getDataFromIntent(intent)

        eventGms?.let {
            UGeofenceEvent.create().apply {
                setGeofenceTransition(eventGms.geofenceTransition)
                setErrorCode(eventGms.errorCode)
                //setGeofenceUniqueId(eventGms.)
            }
        }

        eventHms?.let {
            UGeofenceEvent.create().apply {
                setGeofenceTransition(eventHms.conversion)
                setErrorCode(eventHms.errorCode)
                //setGeofenceUniqueId(eventHms.)
            }
        }

    }

    abstract fun onEventReceived(event: UGeofenceEvent)
}
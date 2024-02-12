package com.example.universalgeomanager.universalLocation.settingsClient

import android.content.Intent
import android.os.Parcel

interface LocationSettingsStates {
    fun fromIntent(intent: Intent): LocationSettingsStates
    fun isBlePresent(): Boolean
    fun isBleUsable(): Boolean
    fun isGpsPresent(): Boolean
    fun isGpsUsable(): Boolean
    fun isLocationPresent(): Boolean
    fun isLocationUsable(): Boolean
    fun isNetworkLocationPresent(): Boolean
    fun isNetworkLocationUsable(): Boolean
    fun writeToParcel(dest: Parcel, flags: Int)
}
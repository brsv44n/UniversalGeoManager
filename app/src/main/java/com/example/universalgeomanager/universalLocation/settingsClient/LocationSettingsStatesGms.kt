package com.example.universalgeomanager.universalLocation.settingsClient

import android.content.Intent
import android.os.Parcel

class LocationSettingsStatesGms(
    private val locationSettingsStates: com.google.android.gms.location.LocationSettingsStates?
):LocationSettingsStates{
    override fun fromIntent(intent: Intent): LocationSettingsStates {
        TODO()
    }

    override fun isBlePresent(): Boolean = locationSettingsStates!!.isBlePresent

    override fun isBleUsable(): Boolean = locationSettingsStates!!.isBleUsable

    override fun isGpsPresent(): Boolean = locationSettingsStates!!.isGpsPresent

    override fun isGpsUsable(): Boolean = locationSettingsStates!!.isGpsUsable

    override fun isLocationPresent(): Boolean = locationSettingsStates!!.isLocationPresent

    override fun isLocationUsable(): Boolean = locationSettingsStates!!.isLocationUsable

    override fun isNetworkLocationPresent(): Boolean = locationSettingsStates!!.isNetworkLocationPresent

    override fun isNetworkLocationUsable(): Boolean = locationSettingsStates!!.isNetworkLocationUsable

    override fun writeToParcel(dest: Parcel, flags: Int) = locationSettingsStates!!.writeToParcel(dest, flags)
}
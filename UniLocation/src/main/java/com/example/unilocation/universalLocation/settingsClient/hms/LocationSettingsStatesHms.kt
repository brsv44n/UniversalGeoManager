package com.example.unilocation.universalLocation.settingsClient.hms

import android.content.Intent
import android.os.Parcel
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsStates

class LocationSettingsStatesHms(
    private val locationSettingsStates: com.huawei.hms.location.LocationSettingsStates?
): LocationSettingsStates {
    override fun fromIntent(intent: Intent): LocationSettingsStates {
        TODO()
    }

    override fun isBlePresent(): Boolean = locationSettingsStates?.isBlePresent.let { this.isBlePresent() }

    override fun isBleUsable(): Boolean = locationSettingsStates?.isBleUsable.let { this.isGpsUsable() }

    override fun isGpsPresent(): Boolean = locationSettingsStates?.isGpsPresent.let { this.isGpsPresent() }

    override fun isGpsUsable(): Boolean = locationSettingsStates?.isGpsUsable.let { this.isGpsUsable() }

    override fun isLocationPresent(): Boolean = locationSettingsStates?.isLocationPresent.let { this.isLocationPresent() }

    override fun isLocationUsable(): Boolean = locationSettingsStates?.isLocationUsable.let { this.isLocationUsable() }

    override fun isNetworkLocationPresent(): Boolean = locationSettingsStates?.isNetworkLocationPresent.let { this.isNetworkLocationPresent() }

    override fun isNetworkLocationUsable(): Boolean = locationSettingsStates?.isNetworkLocationUsable.let { this.isNetworkLocationUsable() }

    override fun writeToParcel(dest: Parcel, flags: Int) = locationSettingsStates!!.writeToParcel(dest, flags)
}
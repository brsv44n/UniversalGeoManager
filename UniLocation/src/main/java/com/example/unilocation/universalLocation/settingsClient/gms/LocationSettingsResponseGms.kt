package com.example.unilocation.universalLocation.settingsClient.gms

import com.example.unilocation.universalLocation.settingsClient.LocationSettingsResponse
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsStates

class LocationSettingsResponseGms(
    private val locSetResponse: com.google.android.gms.location.LocationSettingsResponse
): LocationSettingsResponse {
    override fun getLocationSettingsStates(): LocationSettingsStates {
        return LocationSettingsStatesGms(locSetResponse.locationSettingsStates)
    }
}
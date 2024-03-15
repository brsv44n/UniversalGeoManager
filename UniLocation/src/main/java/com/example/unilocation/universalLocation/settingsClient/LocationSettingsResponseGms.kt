package com.example.unilocation.universalLocation.settingsClient

class LocationSettingsResponseGms(
    private val locSetResponse: com.google.android.gms.location.LocationSettingsResponse
): LocationSettingsResponse {
    override fun getLocationSettingsStates(): LocationSettingsStates {
        return LocationSettingsStatesGms(locSetResponse.locationSettingsStates)
    }
}
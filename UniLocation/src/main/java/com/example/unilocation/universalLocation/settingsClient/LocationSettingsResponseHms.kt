package com.example.unilocation.universalLocation.settingsClient

class LocationSettingsResponseHms(
    private val locSetResponse: com.huawei.hms.location.LocationSettingsResponse
): LocationSettingsResponse {
    override fun getLocationSettingsStates(): LocationSettingsStates {
        return LocationSettingsStatesHms(locSetResponse.locationSettingsStates)
    }
}
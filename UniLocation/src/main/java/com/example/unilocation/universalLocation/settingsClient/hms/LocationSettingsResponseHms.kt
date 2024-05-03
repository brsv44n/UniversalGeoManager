package com.example.unilocation.universalLocation.settingsClient.hms

import com.example.unilocation.universalLocation.settingsClient.LocationSettingsResponse
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsStates

class LocationSettingsResponseHms(
    private val locSetResponse: com.huawei.hms.location.LocationSettingsResponse
): LocationSettingsResponse {
    override fun getLocationSettingsStates(): LocationSettingsStates {
        return LocationSettingsStatesHms(locSetResponse.locationSettingsStates)
    }
}
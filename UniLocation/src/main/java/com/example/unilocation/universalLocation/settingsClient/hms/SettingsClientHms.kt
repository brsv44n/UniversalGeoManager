package com.example.unilocation.universalLocation.settingsClient.hms

import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.example.unilocation.universalLocation.TaskWrapper
import com.example.unilocation.universalLocation.hms.TaskWrapperHms
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsRequest
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsResponse
import com.example.unilocation.universalLocation.settingsClient.SettingsClientInterface
import com.huawei.hms.location.LocationServices

class SettingsClientHms(private val context: Context): SettingsClientInterface {

    private val settingsClient: com.huawei.hms.location.SettingsClient = LocationServices.getSettingsClient(context)

    override fun checkLocationSettings(locationSettingsRequest: LocationSettingsRequest): TaskWrapper<LocationSettingsResponse> {
        val locationSettingsRequestHmsMapper = LocationSettingRequestHmsMapper()

        val locationSettingsRequestHMS = locationSettingsRequestHmsMapper.createLocationSettingsRequest(locationSettingsRequest)
        return TaskWrapperHms(
            settingsClient.checkLocationSettings(locationSettingsRequestHMS).continueWith { LocationSettingsResponseHms(it.result) }
        )

    }

    override fun openLocationSettings() {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        context.startActivity(intent)
    }
}
package com.example.unilocation.universalLocation.settingsClient.gms

import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.example.unilocation.universalLocation.TaskWrapper
import com.example.unilocation.universalLocation.gms.TaskWrapperGms
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsRequest
import com.example.unilocation.universalLocation.settingsClient.LocationSettingsResponse
import com.example.unilocation.universalLocation.settingsClient.SettingsClientInterface
import com.google.android.gms.location.LocationServices

class SettingsClientGms(private val context: Context): SettingsClientInterface {

    private val settingsClient: com.google.android.gms.location.SettingsClient = LocationServices.getSettingsClient(context)

    override fun checkLocationSettings(locationSettingsRequest: LocationSettingsRequest): TaskWrapper<LocationSettingsResponse> {
        val locationSettingsRequestGmsMapper = LocationSettingRequestGmsMapper()

        val locationSettingsRequestGMS = locationSettingsRequestGmsMapper.createLocationSettingsRequest(locationSettingsRequest)
        return TaskWrapperGms(
            settingsClient.checkLocationSettings(locationSettingsRequestGMS).continueWith { LocationSettingsResponseGms(it.result) }
        )

    }

    override fun openLocationSettings() {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        context.startActivity(intent)
    }
}
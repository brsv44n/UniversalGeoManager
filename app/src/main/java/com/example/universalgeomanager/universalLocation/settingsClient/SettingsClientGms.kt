package com.example.universalgeomanager.universalLocation.settingsClient

import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.example.universalgeomanager.universalLocation.LocationRequest
import com.example.universalgeomanager.universalLocation.LocationRequestGmsMapper
import com.example.universalgeomanager.universalLocation.TaskWrapper
import com.example.universalgeomanager.universalLocation.TaskWrapperGms
import com.google.android.gms.location.LocationServices

class SettingsClientGms(private val context: Context): SettingsClientInterface {

    private val settingsClient: com.google.android.gms.location.SettingsClient = LocationServices.getSettingsClient(context)

    private val locationRequestMapper = LocationRequestGmsMapper()

    override fun checkLocationSettings(locationRequest: LocationRequest): TaskWrapper<LocationSettingsResponse> {
        val builder = com.google.android.gms.location.LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequestMapper.createGmsLocationRequest(locationRequest))
        return TaskWrapperGms(
            settingsClient.checkLocationSettings(builder.build()).continueWith { task ->
                LocationSettingsResponseGms(task.result)
            }
        )

    }

    override fun openLocationSettings() {
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        context.startActivity(intent)
    }
}
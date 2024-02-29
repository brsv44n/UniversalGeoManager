package com.example.universalgeomanager.universalLocation.settingsClient

import com.example.universalgeomanager.universalLocation.LocationRequest
import com.example.universalgeomanager.universalLocation.TaskWrapper

interface SettingsClientInterface {
    fun checkLocationSettings (locationSettingsRequest: LocationSettingsRequest): TaskWrapper<LocationSettingsResponse>
    fun openLocationSettings()
}
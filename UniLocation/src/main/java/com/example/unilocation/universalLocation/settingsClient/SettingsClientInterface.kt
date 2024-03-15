package com.example.unilocation.universalLocation.settingsClient

import com.example.unilocation.universalLocation.TaskWrapper

interface SettingsClientInterface {
    fun checkLocationSettings (locationSettingsRequest: LocationSettingsRequest): TaskWrapper<LocationSettingsResponse>
    fun openLocationSettings()
}
package com.example.universalgeomanager.universalLocation.settingsClient

interface LocationSettingsResult {
    fun getLocationSettingsStates(): LocationSettingsStates
    fun getStatus(): Status
    fun writeToParcel()
}
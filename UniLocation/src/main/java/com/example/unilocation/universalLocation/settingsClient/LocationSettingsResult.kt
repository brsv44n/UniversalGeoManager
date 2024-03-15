package com.example.unilocation.universalLocation.settingsClient

interface LocationSettingsResult {
    fun getLocationSettingsStates(): LocationSettingsStates
    fun getStatus(): Status
    fun writeToParcel()
}
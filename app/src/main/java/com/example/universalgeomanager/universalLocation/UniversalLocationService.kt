package com.example.universalgeomanager.universalLocation

import android.content.Context

object UniversalLocationService {

    fun getLocationProviderClient(context: Context): LocationProviderClient = TODO()
    //if (gmsAvailable) LocationProviderClientGms(context)
    // else if (hmsAvailable) LocationProviderClientHms(context)
    // else DefaultLocationClient(context) который на LocationManager-e работает
}
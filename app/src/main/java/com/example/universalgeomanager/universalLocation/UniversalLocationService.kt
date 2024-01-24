package com.example.universalgeomanager.universalLocation

import android.content.Context
import com.example.universalgeomanager.utils.isGMSAvailable
import com.example.universalgeomanager.utils.isHMSAvailable

object UniversalLocationService {

    fun getLocationProviderClient(context: Context): LocationProviderClient {
        return if (isGMSAvailable(context)) LocationProviderClientGms(context)
        else if (isHMSAvailable(context)) LocationProviderClientHms(context)
        else TODO("DefaultLocationClient(context) который на LocationManager-e работает")
    }

}
package com.example.unilocation.universalLocation

import android.content.Context
import com.example.unilocation.universalLocation.gms.LocationProviderClientGms
import com.example.unilocation.universalLocation.hms.LocationProviderClientHms
import com.example.unilocation.utils.isGMSAvailable
import com.example.unilocation.utils.isHMSAvailable

object UniversalLocationService {

    fun getLocationProviderClient(context: Context): LocationProviderClient {
        return if (isGMSAvailable(context)) LocationProviderClientGms(
            context
        )
        else if (isHMSAvailable(context)) LocationProviderClientHms(context)
        else TODO("DefaultLocationClient(context) который на LocationManager-e работает")
    }

}
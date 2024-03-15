package com.example.unilocation.utils

import android.content.Context
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.huawei.hms.api.HuaweiApiAvailability

fun isHMSAvailable (context: Context): Boolean {
    val isHmsAvailable = HuaweiApiAvailability.getInstance()
    val resultCodeHms = isHmsAvailable.isHuaweiMobileServicesAvailable(context)

    if (resultCodeHms == ConnectionResult.SUCCESS) {
        Log.d("ServicesAvailability", "Huawei Mobile Services is available")
        return true
    } else {
        Log.d("ServicesAvailability", "Huawei Mobile Services is not available")
        return false
    }
}

fun isGMSAvailable (context: Context): Boolean {
    val googleApiAvailability = GoogleApiAvailability.getInstance()
    val resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context)

    if (resultCode == ConnectionResult.SUCCESS) {
        Log.d("ServicesAvailability", "Google Play Services is available")
        return true
    } else {
        if (googleApiAvailability.isUserResolvableError(resultCode)) {
            Log.d("ServicesAvailability", "Google Play Services is not available")
            return false
        } else {
            Log.d("ServicesAvailability", "Google Play Services is not installed and can't be")
            return false
        }
    }
}

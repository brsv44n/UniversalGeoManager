package com.example.universalgeomanager.utils

import android.content.Context
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.huawei.hms.api.HuaweiApiAvailability

fun isHMSAvailable (context: Context) {
    val isHmsAvailable = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context) == ConnectionResult.SUCCESS
    val resultCodeHms = isHmsAvailable
    if (isHmsAvailable) {
        Log.d("MainActivityLogs", "Huawei Mobile Services is available")
    } else {
        Log.d("MainActivityLogs", "Huawei Mobile Services is not available")
    }
}

fun isGMSAvailable (context: Context) {
    val googleApiAvailability = GoogleApiAvailability.getInstance()
    val resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context)

    if (resultCode == ConnectionResult.SUCCESS) {
        Log.d("MainActivityLogs", "Google Play Services is available")
    } else {
        if (googleApiAvailability.isUserResolvableError(resultCode)) {
            Log.d("MainActivityLogs", "Google Play Services is not available")
        } else {
            Log.d("MainActivityLogs", "Google Play Services is not installed and can't be")
        }
    }
}

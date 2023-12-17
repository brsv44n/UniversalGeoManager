package com.example.universalgeomanager

import android.content.Context
import android.content.Context.*
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import com.example.universalgeomanager.ui.theme.UniversalGeoManagerTheme
import com.example.universalgeomanager.universalLocation.ULocationManager
import com.example.universalgeomanager.utils.PermissionHelper
import com.example.universalgeomanager.utils.isGMSAvailable
import com.example.universalgeomanager.utils.isHMSAvailable
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.huawei.hms.api.HuaweiApiAvailability
import com.huawei.hms.common.api.AvailabilityException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isHMSAvailable(this)

        isGMSAvailable(this)

        val ulocationManager = ULocationManager(this)

        if (!PermissionHelper.checkLocationPermission(this)) {
            PermissionHelper.requestLocationPermission(this)
        } else {
            ulocationManager.getLastLocation()
            Log.d("MainActivityLogs", "Permission granted")
        }


        setContent {
            UniversalGeoManagerTheme {



            }
        }
    }
}

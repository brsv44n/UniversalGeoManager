package com.example.universalgeomanager

import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.universalgeomanager.ui.theme.UniversalGeoManagerTheme
import com.example.universalgeomanager.universalLocation.LocationProviderClientGms
import com.example.universalgeomanager.universalLocation.LocationProviderClientHms
import com.example.universalgeomanager.universalLocation.OnSuccessListener
import com.example.universalgeomanager.universalLocation.logFields
import com.example.universalgeomanager.utils.PermissionHelper
import com.example.universalgeomanager.utils.isGMSAvailable
import com.example.universalgeomanager.utils.isHMSAvailable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isHMSAvailable(this)

        isGMSAvailable(this)

        val locationProvider = LocationProviderClientHms(this)

        if (!PermissionHelper.checkLocationPermission(this)) {
            PermissionHelper.requestLocationPermission(this)
        } else {
            locationProvider.getLastLocation()
                .addOnSuccessListener(object : OnSuccessListener<Location> {
                    override fun onSuccess(result: Location) {
                        Log.d("MainActivityLogs", "longitude: ${result.longitude}, latitude: ${result.latitude}")
                    }
                })
            Log.d("MainActivityLogs", "Permission granted")

        }


        setContent {
            UniversalGeoManagerTheme {



            }
        }
    }
}

package com.example.universalgeomanager

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.universalgeomanager.ui.theme.UniversalGeoManagerTheme
import com.example.universalgeomanager.universalLocation.LocationRequest
import com.example.universalgeomanager.universalLocation.OnCompleteListener
import com.example.universalgeomanager.universalLocation.UniversalLocationService
import com.example.universalgeomanager.universalLocation.location.LocationAvailability
import com.example.universalgeomanager.universalLocation.location.LocationCallback
import com.example.universalgeomanager.universalLocation.location.LocationResult
import com.example.universalgeomanager.utils.PermissionHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * реализовать универсальный SettingsClient для hms/gms и все сопутствующее - LocationSettingsRequest, LocationSettingsResponse, LocationSettingsStates, ResolvableApiException и т.д.
 * реализовать LocationProviderClient для дефолтного LocationManager (надо думать как)
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val locationProviderClient = UniversalLocationService.getLocationProviderClient(this)
        locationProviderClient.getLocationAvailability().addOnCompleteListener(object : OnCompleteListener<LocationAvailability> {
            override fun onComplete(task: Any) {
                Log.d("MainActivityLogs", "Location is available from location availability")
            }
        })

        val callback = object : LocationCallback {
            override fun onLocationAvailability(availability: LocationAvailability) {
                Log.d("MainActivityLogs", "Location is available")
            }

            override fun onLocationResult(locationResult: LocationResult) {
                //Log.d("MainActivityLogs", "longitude: ${result.getLastLocation()?.longitude} latitude: ${result.getLastLocation()?.latitude}")
                locationResult ?: return
                for (location in locationResult.getLocations()) {
                    // Вывод результата в консоль
                    Log.d("MainActivityLogs", "Latitude1: ${location.latitude}, Longitude1: ${location.longitude}")
                }
            }
        }

        val currRequest1 = LocationRequest.create().apply {
            setPriority(100)
            setInterval(10000)
        }

        if (!PermissionHelper.checkLocationPermission(this)) {
            PermissionHelper.requestLocationPermission(this)
        } else {
            locationProviderClient.requestLocationUpdates(currRequest1, callback, null)
            Log.d("MainActivityLogs", "Permission granted")
        }

        setContent {
            UniversalGeoManagerTheme {
            }
        }
    }
}

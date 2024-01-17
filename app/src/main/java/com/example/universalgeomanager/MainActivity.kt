package com.example.universalgeomanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.universalgeomanager.ui.theme.UniversalGeoManagerTheme
import com.example.universalgeomanager.universalLocation.LocationRequest
import com.example.universalgeomanager.universalLocation.UniversalLocationService
import com.example.universalgeomanager.universalLocation.location.LocationAvailability
import com.example.universalgeomanager.universalLocation.location.LocationCallback
import com.example.universalgeomanager.universalLocation.location.LocationResult

/**
 * План:
 * 1) доделать LocationRequest
 * 2) доделать LocationProviderClient и реализации, проверить
 * 3) если в п2 понадобится - добавить недостающие методы в TaskWrapper (см коммент там) и реализовать для gms/hms
 * 4) реализовать универсальный SettingsClient для hms/gms и все сопутствующее - LocationSettingsRequest, LocationSettingsResponse, LocationSettingsStates, ResolvableApiException и т.д.
 * 5) реализовать LocationProviderClient для дефолтного LocationManager (надо думать как)
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val locationProviderClient = UniversalLocationService.getLocationProviderClient(this)
        locationProviderClient.getLastLocation()
        locationProviderClient.getLocationAvailability()
        val callback = object : LocationCallback {
            override fun onLocationAvailability(availability: LocationAvailability) {
                TODO("Not yet implemented")
            }

            override fun onLocationResult(result: LocationResult) {
                TODO("Not yet implemented")
            }
        }
        locationProviderClient.requestLocationUpdates(LocationRequest.create(), callback, null)

        setContent {
            UniversalGeoManagerTheme {
            }
        }
    }
}

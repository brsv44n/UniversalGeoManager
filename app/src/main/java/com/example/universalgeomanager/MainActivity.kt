package com.example.universalgeomanager

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.universalgeomanager.ui.theme.UniversalGeoManagerTheme
import com.example.universalgeomanager.universalGeofence.Geofence
import com.example.universalgeomanager.universalGeofence.GeofenceBroadcastReceiver
import com.example.universalgeomanager.universalGeofence.GeofenceRequest
import com.example.universalgeomanager.universalGeofence.UniversalGeofenceService
import com.example.universalgeomanager.universalLocation.LocationRequest
import com.example.universalgeomanager.universalLocation.OnCompleteListener
import com.example.universalgeomanager.universalLocation.OnFailureListener
import com.example.universalgeomanager.universalLocation.OnSuccessListener
import com.example.universalgeomanager.universalLocation.UniversalLocationService
import com.example.universalgeomanager.universalLocation.location.LocationAvailability
import com.example.universalgeomanager.universalLocation.location.LocationCallback
import com.example.universalgeomanager.universalLocation.location.LocationResult
import com.example.universalgeomanager.utils.PermissionHelper

/**
 * реализовать универсальный SettingsClient для hms/gms и все сопутствующее - LocationSettingsRequest, LocationSettingsResponse, LocationSettingsStates, ResolvableApiException и т.д.
 * реализовать LocationProviderClient для дефолтного LocationManager (надо думать как)
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val geofenceProviderClient = UniversalGeofenceService.getGeofenceClient(this)

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

        val geofencePendingIntent: PendingIntent by lazy {
            val intent = Intent(this, GeofenceBroadcastReceiver::class.java)
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val geofence = Geofence.create().apply {
            setRequestId("First_geofence")
            setCircularRegion(43.1195157, 131.8978022, 10f)
            setExpirationDuration(10000)
            setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)
        }
        val geofenceRequest1 = GeofenceRequest.create().apply {
            addGeofence(geofence)
            setInitialTrigger(GeofenceRequest.INITIAL_TRIGGER_ENTER)
        }

        geofenceProviderClient.addGeofences(geofenceRequest1, geofencePendingIntent).addOnSuccessListener(
            object : OnSuccessListener<Any> {
                override fun onSuccess(result: Any) {
                    Log.d("MainActivityLogs", "New Geofence added successfully")
                }
            }
        ).addOnFailureListener(
            object : OnFailureListener {
                override fun onFailure() {
                    Log.d("MainActivityLogs", "In process, new Geofence wasn't added")
                }
            }
        )

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

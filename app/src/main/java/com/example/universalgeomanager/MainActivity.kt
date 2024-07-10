package com.example.universalgeomanager

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.unilocation.universalLocation.LocationRequest
import com.example.unilocation.universalLocation.OnCompleteListener
import com.example.unilocation.universalLocation.OnFailureListener
import com.example.unilocation.universalLocation.OnSuccessListener
import com.example.unilocation.universalLocation.UniversalLocationService
import com.example.unilocation.universalLocation.location.LocationAvailability
import com.example.unilocation.universalLocation.location.LocationCallback
import com.example.unilocation.universalLocation.location.LocationResult
import com.example.universalgeomanager.presentation.MainScreen
import com.example.universalgeomanager.presentation.setMapConfigurations
import com.example.universalgeomanager.ui.theme.UniversalGeoManagerTheme
import org.osmdroid.config.Configuration
import org.osmdroid.views.MapView

lateinit var mainScreenMapView: MapView
class MainActivity : ComponentActivity() {
    override fun onResume() {
        super.onResume()
        mainScreenMapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mainScreenMapView.onPause()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val geofenceProviderClient = com.example.unilocation.universalGeofence.UniversalGeofenceService.getGeofenceClient(this)
//
//        val locationProviderClient = UniversalLocationService.getLocationProviderClient(this)
//        locationProviderClient.getLocationAvailability().addOnCompleteListener(object :
//            OnCompleteListener<LocationAvailability> {
//            override fun onComplete(task: Any) {
//                Log.d("MainActivityLogs", "Location is available from location availability")
//            }
//        })
//
//        val callback = object : LocationCallback {
//            override fun onLocationAvailability(availability: LocationAvailability) {
//                Log.d("MainActivityLogs", "Location is available")
//            }
//
//            override fun onLocationResult(locationResult: LocationResult) {
//                locationResult ?: return
//                for (location in locationResult.getLocations()) {
//                    // Вывод результата в консоль
//                    Log.d("MainActivityLogs", "Latitude1: ${location.latitude}, Longitude1: ${location.longitude}")
//                }
//            }
//        }
//
//        val currRequest1 = LocationRequest.create().apply {
//            setPriority(100)
//            setInterval(10000)
//        }
//
//        val geofencePendingIntent: PendingIntent by lazy {
//            val intent = Intent(this, com.example.unilocation.universalGeofence.GeofenceBroadcastReceiver::class.java)
//            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//        }
//        val geofence = com.example.unilocation.universalGeofence.Geofence.create().apply {
//            setRequestId("First_geofence")
//            setCircularRegion(43.1195157, 131.8978022, 10f)
//            setExpirationDuration(10000)
//            setTransitionTypes(com.example.unilocation.universalGeofence.Geofence.GEOFENCE_TRANSITION_ENTER)
//        }
//        val geofenceRequest1 = com.example.unilocation.universalGeofence.GeofenceRequest.create().apply {
//            addGeofence(geofence)
//            setInitialTrigger(com.example.unilocation.universalGeofence.GeofenceRequest.INITIAL_TRIGGER_ENTER)
//        }
//
//        geofenceProviderClient.addGeofences(geofenceRequest1, geofencePendingIntent).addOnSuccessListener(
//            object : OnSuccessListener<Any> {
//                override fun onSuccess(result: Any) {
//                    Log.d("MainActivityLogs", "New Geofence added successfully")
//                }
//            }
//        ).addOnFailureListener(
//            object : OnFailureListener {
//                override fun onFailure(exception: Exception) {
//                    Log.d("MainActivityLogs", "${exception.message}")
//                }
//            }
//        )

        if (!com.example.unilocation.utils.PermissionHelper.checkLocationPermission(this)) {
            com.example.unilocation.utils.PermissionHelper.requestLocationPermission(this)
        } else {
            //locationProviderClient.requestLocationUpdates(currRequest1, callback, null)
            Log.d("MainActivityLogs", "Permission granted")
        }

        Configuration.getInstance().userAgentValue = packageName
        mainScreenMapView = MapView(baseContext)

        setContent {
            MainScreen(mainScreenMapView)
        }
    }
}

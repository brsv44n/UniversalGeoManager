package com.example.universalgeomanager.universalLocation

import android.annotation.SuppressLint
import android.content.Context
import android.location.LocationManager
import android.location.LocationManager.FUSED_PROVIDER
import android.util.Log
import com.example.universalgeomanager.utils.isGMSAvailable
import com.example.universalgeomanager.utils.isHMSAvailable
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class ULocationManager(private val context: Context): ULocationManagerInterface {

    private val GMSfusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    private val HMSfusedLocationClient: com.huawei.hms.location.FusedLocationProviderClient
    = com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(context)

    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

//    init {
//        if (isGMSAvailable(context = context)) {
//            //fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
//        } else if (isHMSAvailable(context = context)) {
//
//        } else {
//
//        }
//    }
    @SuppressLint("MissingPermission")
    override fun getLastLocation() {
        if (isGMSAvailable(context = context)) {

            GMSfusedLocationClient.lastLocation
                .addOnSuccessListener { location: android.location.Location? ->
                    Log.d("ListenerGMS", "Everything's alright")
                    if (location != null) {

                        val latitude = location.latitude
                        val longitude = location.longitude
                        Log.d("ListenerGMS", "latitude: ${latitude} longitude: ${longitude}")
                    }
                }
                .addOnFailureListener { e: Exception ->
                    Log.d("ListenerGMS", "Something went wrong on getting location. ${e.message}")
                }

        } else if (isHMSAvailable(context = context)) {
            HMSfusedLocationClient.lastLocation.addOnSuccessListener { location: android.location.Location? ->
                Log.d("ListenerHMS", "Everything's alright")
                if (location != null) {

                    val latitude = location.latitude
                    val longitude = location.longitude
                    Log.d("ListenerHMS", "latitude: ${latitude} longitude: ${longitude}")
                }
            }
                .addOnFailureListener { e: Exception ->
                    Log.d("ListenerHMS", "Something went wrong on getting location. ${e.message}")
                }
        } else {

//            locationManager.getCurrentLocation(FUSED_PROVIDER, locationListener, null)

        }
    }

    override fun requestLocationUpdates() {
        TODO("Not yet implemented")
    }

    override fun removeLocationUpdates() {
        TODO("Not yet implemented")
    }

}
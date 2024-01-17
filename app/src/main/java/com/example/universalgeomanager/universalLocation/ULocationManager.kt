package com.example.universalgeomanager.universalLocation

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.FUSED_PROVIDER
import android.util.Log
import com.example.universalgeomanager.utils.isGMSAvailable
import com.example.universalgeomanager.utils.isHMSAvailable
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.lang.reflect.Modifier

//TODO лишнее, можно выпилить
class ULocationManager(private val context: Context): ULocationManagerInterface {

    private val GMSfusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    private val HMSfusedLocationClient: com.huawei.hms.location.FusedLocationProviderClient
    = com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(context)

    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

//    private val locationListener = object : LocationListener {
//        override fun onLocationChanged(location: android.location.Location) {
//            // Обработка полученного местоположения
//            val latitude = location.latitude
//            val longitude = location.longitude
//            Log.d("LocationListener", "latitude: ${latitude}, longitude: ${longitude}")
//        }
//        // Реализация остальных методов интерфейса LocationListener
//    }
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
    override fun getLastLocation(): TaskWrapper<com.example.universalgeomanager.models.Location> {
        if (isGMSAvailable(context = context)) {

            GMSfusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    Log.d("ListenerGMS", "Everything's alright")
                    if (location != null) {
                        // TODO make return call outside listener
                        // return location.toMyLocation()
                        val latitude = location.latitude
                        val longitude = location.longitude
                        Log.d("ListenerGMS", "latitude: ${latitude} longitude: ${longitude}")
                    }
                }
                .addOnFailureListener { e: Exception ->
                    Log.d("ListenerGMS", "Something went wrong on getting location. ${e.message}")
                }

        } else if (isHMSAvailable(context = context)) {
            HMSfusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
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

            locationManager.getLastKnownLocation(FUSED_PROVIDER).let { location: Location? ->
                Log.d("ListenerDefault", "Everything's alright")
                if (location != null) {

                    val latitude = location.latitude
                    val longitude = location.longitude
                    Log.d("ListenerDefault", "latitude: ${latitude} longitude: ${longitude}")
                }
            }


        }
    return TODO("Provide the return value")
}

    override fun requestLocationUpdates(request: LocationRequest): TaskWrapper<Any> {
        TODO("Not yet implemented")
    }

    override fun removeLocationUpdates(): TaskWrapper<Any> {
        TODO("Not yet implemented")
    }
}

fun Any.logFields(tag: String) {
    val fields = this.javaClass.declaredFields
    val className = this.javaClass.simpleName
    val _tag = tag

    for (field in fields) {
        field.isAccessible = true
        val modifiers = Modifier.toString(field.modifiers)
        val value = field.get(this)
        Log.d(_tag, "$className: $modifiers ${field.name} = $value")
    }
}
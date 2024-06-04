package com.example.unilocation.universalLocation.dls

import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Looper
import androidx.annotation.RequiresPermission
import com.example.unilocation.universalLocation.LocationProviderClient
import com.example.unilocation.universalLocation.LocationRequest
import com.example.unilocation.universalLocation.TaskWrapper
import com.example.unilocation.universalLocation.location.LocationAvailability
import com.example.unilocation.universalLocation.location.LocationCallback

//class LocationProviderClientDls(private val context: Context): LocationProviderClient {
//
//    private val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
//
//    //TODO после написания класса Task для дефолтного manager изменить реализацию
//    @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
//    override fun getLastLocation(callback: LocationCallbackDls): TaskWrapper<Location> {
//        val lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
//        if (lastKnownLocation != null) {
//            callback.onSuccess(lastKnownLocation)
//        } else {
//            callback.onFailure(Exception("Last known location not found"))
//        }
//    }
//
//    override fun requestLocationUpdates(
//        request: LocationRequest,
//        locationCallback: LocationCallback,
//        looper: Looper?
//    ): TaskWrapper<Any> {
//        TODO("Not yet implemented")
//    }
//
//    override fun removeLocationUpdates(locationCallback: LocationCallback) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getLocationAvailability(): TaskWrapper<LocationAvailability> {
//        TODO("Not yet implemented")
//    }
//
//    override fun flushLocations(): TaskWrapper<Any> {
//        TODO("Not yet implemented")
//    }
//}
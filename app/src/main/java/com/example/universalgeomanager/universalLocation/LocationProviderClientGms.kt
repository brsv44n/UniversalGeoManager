package com.example.universalgeomanager.universalLocation

import android.content.Context
import android.location.Location
import android.os.Looper
import androidx.annotation.RequiresPermission
import com.example.universalgeomanager.universalLocation.location.LocationAvailability
import com.example.universalgeomanager.universalLocation.location.LocationAvailabilityGms
import com.example.universalgeomanager.universalLocation.location.LocationCallback
import com.example.universalgeomanager.universalLocation.location.LocationResultGms
import com.example.universalgeomanager.universalLocation.location.LocationResult
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.concurrent.ConcurrentHashMap

class LocationProviderClientGms(private val context: Context): LocationProviderClient {

    private val locationProvider: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    private val callbacks =
        ConcurrentHashMap<LocationCallback, com.google.android.gms.location.LocationCallback>()

    @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
    override fun getLastLocation(): TaskWrapper<Location> =
        TaskWrapperGms(locationProvider.lastLocation)

    private val locationRequestMapper = LocationRequestGmsMapper()
    @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
    override fun requestLocationUpdates(
        request: LocationRequest,
        locationCallback: LocationCallback,
        looper: Looper?
    ): TaskWrapper<Any> {
        val locationCallbackGms = object : com.google.android.gms.location.LocationCallback() {
            override fun onLocationResult(locationResult: com.google.android.gms.location.LocationResult) =
                locationCallback.onLocationResult(LocationResultGms(locationResult))

            override fun onLocationAvailability(locationAvailability: com.google.android.gms.location.LocationAvailability) =
                locationCallback.onLocationAvailability(
                    LocationAvailabilityGms(locationAvailability)
                )
        }

        callbacks[locationCallback] = locationCallbackGms
        return TaskWrapperGms(
            locationProvider.requestLocationUpdates(
                locationRequestMapper.createGmsLocationRequest(request),
                locationCallbackGms,
                looper
            ).continueWith {  }
        )

    }

    override fun removeLocationUpdates(locationCallback: LocationCallback) {
        callbacks[locationCallback]?.let {
            locationProvider.removeLocationUpdates(it)
            callbacks.remove(locationCallback)
        }
    }

    @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
    override fun getLocationAvailability(): TaskWrapper<LocationAvailability> {
        //TODO проверить что continueWith работает корректно - возвразщает LocationAvailabilityGms в случае успеха и правильно возвращает ошибки
        return TaskWrapperGms(locationProvider.locationAvailability.continueWith { LocationAvailabilityGms(it.result) })
    }

    override fun flushLocations(): TaskWrapper<Any> {
        return TaskWrapperGms(locationProvider.flushLocations().continueWith { })
    }
}
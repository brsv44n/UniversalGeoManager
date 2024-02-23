package com.example.universalgeomanager.universalLocation

import android.content.Context
import android.location.Location
import android.os.Looper
import androidx.annotation.RequiresPermission
import com.example.universalgeomanager.universalLocation.location.LocationAvailability
import com.example.universalgeomanager.universalLocation.location.LocationAvailabilityHms
import com.example.universalgeomanager.universalLocation.location.LocationCallback
import com.example.universalgeomanager.universalLocation.location.LocationResultHms
import com.huawei.hms.location.FusedLocationProviderClient
import com.huawei.hms.location.LocationServices
import java.util.concurrent.ConcurrentHashMap

class LocationProviderClientHms(private val context: Context): LocationProviderClient {

    private val locationProvider: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    private val callbacks =
        ConcurrentHashMap<LocationCallback, com.huawei.hms.location.LocationCallback>()

    @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
    override fun getLastLocation(): TaskWrapper<Location> =
        TaskWrapperHms(locationProvider.lastLocation)

    private val locationRequestMapper = LocationRequestHmsMapper()
    @RequiresPermission(anyOf = ["android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"])
    override fun requestLocationUpdates(
        request: LocationRequest,
        locationCallback: LocationCallback,
        looper: Looper?
    ): TaskWrapper<Any> {

        val locationCallbackHms = object : com.huawei.hms.location.LocationCallback() {
            override fun onLocationResult(locationResult: com.huawei.hms.location.LocationResult) =
                locationCallback.onLocationResult(LocationResultHms(locationResult))

            override fun onLocationAvailability(locationAvailability: com.huawei.hms.location.LocationAvailability) =
                locationCallback.onLocationAvailability(LocationAvailabilityHms(locationAvailability))
        }

        callbacks[locationCallback] = locationCallbackHms
        return TaskWrapperHms(
            locationProvider.requestLocationUpdates(
                locationRequestMapper.createHmsLocationRequest(request),
                locationCallbackHms,
                looper
            ).continueWith { }
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
        return TaskWrapperHms(locationProvider.locationAvailability.continueWith { LocationAvailabilityHms(it.result) })
    }

    override fun flushLocations(): TaskWrapper<Any> {
        return TaskWrapperHms(locationProvider.flushLocations().continueWith { })
    }
}
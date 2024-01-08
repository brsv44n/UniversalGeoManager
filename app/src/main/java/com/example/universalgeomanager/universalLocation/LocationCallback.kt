package com.example.universalgeomanager.universalLocation

interface LocationCallback {
    fun onLocationAvailability(locationAvailability: LocationAvailability)
    fun onLocationResult(locationResult: LocationResult)
}

class LocationListenerGms(private val locationCallback: com.google.android.gms.location.LocationCallback): LocationCallback {
    override fun onLocationAvailability(locationAvailability: LocationAvailability) {
        locationCallback.onLocationAvailability(object : com.google.android.gms.location.LocationAvailability{
            override fun isLocationAvailable(): Boolean {
                return super.isLocationAvailable()
            }
        })
    }

    override fun onLocationResult(locationResult: LocationResult) {
        TODO("Not yet implemented")
    }
}

class LocationListenerHms(private val locationCallback: com.google.android.gms.location.LocationCallback): LocationCallback {
    override fun onLocationAvailability(locationAvailability: LocationAvailability) {
        TODO("Not yet implemented")
    }

    override fun onLocationResult(locationResult: LocationResult) {
        TODO("Not yet implemented")
    }
}
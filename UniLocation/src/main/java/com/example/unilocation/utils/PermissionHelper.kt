package com.example.unilocation.utils

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionHelper {

    const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    const val INTERNET_PERMISSION_REQUEST_CODE = 1010

    fun checkLocationPermission(activity: Activity): Boolean {
        val permissionState = ContextCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    fun requestLocationPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    fun checkInternetPermission(activity: Activity): Boolean {
        val permissionState = ContextCompat.checkSelfPermission(activity, android.Manifest.permission.INTERNET)
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    fun requestInternetPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(android.Manifest.permission.INTERNET),
            INTERNET_PERMISSION_REQUEST_CODE
        )
    }

}
package com.example.universalgeomanager.models

data class Location (
    val latitude: Double,
    val longitude: Double,
    val altitude: Double,
    val speed: Float,
    val bearing: Float,
    val accuracy: Float,
    val time: Long,
    val isMock: Boolean,
    val verticalAccuracyMeters: Float,
    val bearingAccuracyDegrees: Float,
    val speedAccuracyMetersPerSecond: Float
    )

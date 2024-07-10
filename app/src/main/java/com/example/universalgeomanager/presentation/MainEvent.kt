package com.example.universalgeomanager.presentation

sealed class MainEvent {
    object GetLastLocation: MainEvent()
    object StartLocationUpdates: MainEvent()
    object StopLocationUpdates: MainEvent()

}
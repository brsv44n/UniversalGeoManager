package com.example.universalgeomanager.presentation

import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {

    fun onEvent(event: MainEvent) {
        when(event) {
            is MainEvent.GetLastLocation -> {

            }
            is MainEvent.StartLocationUpdates -> {

            }
            is MainEvent.StopLocationUpdates -> {

            }
        }
    }

}
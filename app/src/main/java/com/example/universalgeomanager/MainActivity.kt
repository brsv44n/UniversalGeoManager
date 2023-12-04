package com.example.universalgeomanager

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.universalgeomanager.ui.theme.UniversalGeoManagerTheme
import com.example.universalgeomanager.utils.isGMSAvailable
import com.example.universalgeomanager.utils.isHMSAvailable
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.huawei.hms.api.HuaweiApiAvailability
import com.huawei.hms.common.api.AvailabilityException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        isHMSAvailable(this)

        isGMSAvailable(this)

        setContent {
            UniversalGeoManagerTheme {


            }
        }
    }
}

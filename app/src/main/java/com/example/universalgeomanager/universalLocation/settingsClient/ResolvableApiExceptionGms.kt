package com.example.universalgeomanager.universalLocation.settingsClient

import android.app.Activity
import android.app.PendingIntent

class ResolvableApiExceptionGms(
    private val resApiExc: com.google.android.gms.common.api.ResolvableApiException
): ResolvableApiException {
    override fun getResolution(): PendingIntent {
        return resApiExc.resolution
    }

    override fun startResolutionForResult(activity: Activity, requestCode: Int) {
        return resApiExc.startResolutionForResult(activity, requestCode)
    }
}
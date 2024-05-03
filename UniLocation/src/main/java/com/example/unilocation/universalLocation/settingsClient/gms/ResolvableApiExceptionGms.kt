package com.example.unilocation.universalLocation.settingsClient.gms

import android.app.Activity
import android.app.PendingIntent
import com.example.unilocation.universalLocation.settingsClient.ResolvableApiException

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
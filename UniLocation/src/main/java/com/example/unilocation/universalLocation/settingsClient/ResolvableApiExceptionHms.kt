package com.example.unilocation.universalLocation.settingsClient

import android.app.Activity
import android.app.PendingIntent

class ResolvableApiExceptionHms(
    private val resApiExc: com.huawei.hms.common.ResolvableApiException
): ResolvableApiException {
    override fun getResolution(): PendingIntent {
        return resApiExc.resolution
    }

    override fun startResolutionForResult(activity: Activity, requestCode: Int) {
        return resApiExc.startResolutionForResult(activity, requestCode)
    }
}
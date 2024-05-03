package com.example.unilocation.universalLocation.settingsClient.hms

import android.app.Activity
import android.app.PendingIntent
import com.example.unilocation.universalLocation.settingsClient.ResolvableApiException

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
package com.example.unilocation.universalLocation.dls

import android.app.Activity
import android.location.Location
import android.location.LocationManager
import com.example.unilocation.universalLocation.LocationRequest
import com.example.unilocation.universalLocation.OnCancelledListener
import com.example.unilocation.universalLocation.OnCompleteListener
import com.example.unilocation.universalLocation.OnFailureListener
import com.example.unilocation.universalLocation.OnSuccessListener
import com.example.unilocation.universalLocation.TaskWrapper
import java.util.concurrent.Executor

class LocationUpdatesTask(
    private val locationManager: LocationManager,
    private val locationRequest: LocationRequest
): TaskWrapper<Location> {

    /**
     * locationRequest.priority = provider
     * locationRequest.interval = minTimeMs
     * locationRequest.smallestDisplacement = minDistanceM
     * locationRequest.expirationDuration = аналога нет, надо реализовать самому https://developers.google.com/android/reference/com/google/android/gms/location/LocationRequest#setExpirationDuration(long)
     * locationRequest.expirationTime = same https://developers.google.com/android/reference/com/google/android/gms/location/LocationRequest#public-locationrequest-setexpirationtime-long-elapsedrealtime
     * locationRequest.fastestInterval = same https://developers.google.com/android/reference/com/google/android/gms/location/LocationRequest#public-long-getfastestinterval
     * locationRequest.numUpdates = тоже аналогов нет, но вроде просто сделать - отдать результат numUpdates раз и завершить отслеживание
     * но чето все deprecated в гугле уже, мб стоит обновиться если не будет проблем совместимости общих с хуавеем классов
     *
     * маппинг priority в provider предполагаю такой:
     * HIGH_ACCURACY / HD_ACCURACY = LocationManager.GPS_PROVIDER
     * PRIORITY_BALANCED_POWER_ACCURACY / PRIORITY_LOW_POWER = LocationManager.NETWORK_PROVIDER
     * PRIORITY_PASSIVE = LocationManager.PASSIVE_PROVIDER
     */
    init {
        /*locationManager.requestLocationUpdates(
            minTimeMs = locationRequest.interval,
            minDistanceM = locationRequest.smallestDisplacement,

        )*/
        // вызвать locationManager.requestLocationUpdates с соответствующими параметрами
    }
    override fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnCancelledListener(
        listener: OnCancelledListener,
        executor: Executor
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnCancelledListener(
        listener: OnCancelledListener,
        activity: Activity
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnCompleteListener(listener: OnCompleteListener<Location>): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnCompleteListener(
        listener: OnCompleteListener<Location>,
        executor: Executor
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnCompleteListener(
        listener: OnCompleteListener<Location>,
        activity: Activity
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnSuccessListener(listener: OnSuccessListener<in Location>): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnSuccessListener(
        listener: OnSuccessListener<in Location>,
        executor: Executor
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnSuccessListener(
        listener: OnSuccessListener<in Location>,
        activity: Activity
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnFailureListener(
        listener: OnFailureListener,
        executor: Executor
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun addOnFailureListener(
        listener: OnFailureListener,
        activity: Activity
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun getResult(): Location? {
        TODO("Not yet implemented")
    }

    override fun getException(): Exception? {
        TODO("Not yet implemented")
    }

    override fun isCanceled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isComplete(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isSuccessful(): Boolean {
        TODO("Not yet implemented")
    }

    override fun continueWith(
        executor: Executor,
        continuation: (Result<Location>) -> Unit
    ): TaskWrapper<Location> {
        TODO("Not yet implemented")
    }

    override fun <ContinuationResult> continueWithTask(
        executor: Executor,
        continuation: (Result<Location>) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult> {
        TODO("Not yet implemented")
    }

    override fun <ContinuationResult> onSuccessTask(
        executor: Executor,
        continuation: (Location) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult> {
        TODO("Not yet implemented")
    }
}
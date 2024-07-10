package com.example.unilocation.universalLocation.dls

import android.annotation.SuppressLint
import android.app.Activity
import android.location.Location
import android.location.LocationManager
import com.example.unilocation.universalLocation.OnCancelledListener
import com.example.unilocation.universalLocation.OnCompleteListener
import com.example.unilocation.universalLocation.OnFailureListener
import com.example.unilocation.universalLocation.OnSuccessListener
import com.example.unilocation.universalLocation.TaskWrapper
import java.util.concurrent.Executor
import kotlin.coroutines.coroutineContext

@SuppressLint("MissingPermission")
class LastLocationTask (
    locationManager: LocationManager
): TaskWrapper<Location?> {

    private var isComplete = false
    private var isSuccess = false
    private var isCanceled = false
    private var result: Location? = null
    private var exception: Exception? = null

    private val successListeners = mutableListOf<OnSuccessListener<in Location?>>()
    private val completeListeners = mutableListOf<OnCompleteListener<Location?>>()
    private val canceledListeners = mutableListOf<OnCancelledListener>()


    init {
        locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).let { location ->
            result = location
            isSuccess = true
            isComplete = true
            completeListeners.forEach { it.onComplete(this) }
            successListeners.forEach { it.onSuccess(result) }
        }
    }
    override fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Location?> {
        if (isCanceled) {
            listener.onCanceled()
        } else {
            canceledListeners.add(listener)
        }
        return this
    }

    override fun addOnCancelledListener(
        listener: OnCancelledListener,
        executor: Executor
    ): TaskWrapper<Location?> {
        if (isCanceled) {
            executor.execute { listener.onCanceled() }
        } else {
            canceledListeners.add(object : OnCancelledListener {
                override fun onCanceled() {
                    executor.execute { listener.onCanceled() }
                }
            })
        }
        return this
    }

    /**
     * TODO()
     * Но есть ощущение, что активити тут не для того чтобы запускать код в UI потоке, а для того чтобы
     * можно было автоматически удалить слушателя при уничтожении активити. А может быть и то и другое.
     */

    override fun addOnCancelledListener(
        listener: OnCancelledListener,
        activity: Activity
    ): TaskWrapper<Location?> {
        if (isCanceled) {
            activity.runOnUiThread { listener.onCanceled() }

        } else {
            canceledListeners.add(object : OnCancelledListener {
                override fun onCanceled() {
                    activity.runOnUiThread { listener.onCanceled() }
                }
            })
        }
        activity.isDestroyed.let {
            canceledListeners.clear()
        }
        return this
    }

    override fun addOnCompleteListener(listener: OnCompleteListener<Location?>): TaskWrapper<Location?> {
        if (isComplete) {
            listener.onComplete(this)
        } else {
            completeListeners.add(listener)
        }
        return this
    }

    override fun addOnCompleteListener(
        listener: OnCompleteListener<Location?>,
        executor: Executor
    ): TaskWrapper<Location?> {
        if (isComplete) {
            executor.execute { listener.onComplete(this) }
        } else {
            completeListeners.add(object : OnCompleteListener<Location?> {
                override fun onComplete(task: Any) {
                    executor.execute { listener.onComplete(this@LastLocationTask) }
                }
            })
        }
        return this
    }

    override fun addOnCompleteListener(
        listener: OnCompleteListener<Location?>,
        activity: Activity
    ): TaskWrapper<Location?> {
        if (isComplete) {
            activity.runOnUiThread { listener.onComplete(this) }
        } else {
            completeListeners.add(object : OnCompleteListener<Location?> {
                override fun onComplete(task: Any) {
                    activity.runOnUiThread { listener.onComplete(this@LastLocationTask) }
                }
            })
        }
        activity.isDestroyed.let {
            completeListeners.clear()
        }
        return this
    }

    override fun addOnSuccessListener(listener: OnSuccessListener<in Location?>): TaskWrapper<Location?> {
        if (isSuccess) {
            listener.onSuccess(result)
        } else {
            successListeners.add(listener)
        }
        return this
    }

    override fun addOnSuccessListener(
        listener: OnSuccessListener<in Location?>,
        executor: Executor
    ): TaskWrapper<Location?> {
        if (isSuccess) {
            executor.execute { listener.onSuccess(result) }
        } else {
            successListeners.add(object : OnSuccessListener<Location?> {
                override fun onSuccess(result: Location?) {
                    executor.execute { onSuccess(result) }
                }
            })
        }
        return this
    }

    override fun addOnSuccessListener(
        listener: OnSuccessListener<in Location?>,
        activity: Activity
    ): TaskWrapper<Location?> {
        if (isSuccess) {
            activity.runOnUiThread { listener.onSuccess(result) }
        } else {
            successListeners.add(object : OnSuccessListener<Location?> {
                override fun onSuccess(result: Location?) {
                    activity.runOnUiThread { listener.onSuccess(result) }
                }
            })
        }
        activity.isDestroyed.let {
            successListeners.clear()
        }
        return this
    }

    override fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Location?> {
        exception?.let {
            listener.onFailure(it)
        }
        return this
    }

    override fun addOnFailureListener(
        listener: OnFailureListener,
        executor: Executor
    ): TaskWrapper<Location?> {
        exception?.let {
            executor.execute { listener.onFailure(it) }
        }
        return this
    }

    override fun addOnFailureListener(
        listener: OnFailureListener,
        activity: Activity
    ): TaskWrapper<Location?> {
        exception?.let {
            activity.runOnUiThread { listener.onFailure(it) }
        }
        return this
    }

    override fun getResult(): Location? = result

    override fun getException(): Exception? = exception

    override fun isCanceled(): Boolean = isCanceled

    override fun isComplete(): Boolean = isComplete

    override fun isSuccessful(): Boolean = isSuccess

    override fun continueWith(
        executor: Executor,
        continuation: (Result<Location?>) -> Unit
    ): TaskWrapper<Location?> {
//        GlobalScope.launch(executor) {
//            try {
//                val result = await()
//                continuation(Result.success(result))
//            } catch (e: Exception) {
//                continuation(Result.failure(e))
//            }
//        }
        TODO("Not yet implemented")
    }

    override fun <ContinuationResult> continueWithTask(
        executor: Executor,
        continuation: (Result<Location?>) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult> {
        TODO("Not yet implemented")
    }

    override fun <ContinuationResult> onSuccessTask(
        executor: Executor,
        continuation: (Location?) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult> {
        TODO("Not yet implemented")
    }
}
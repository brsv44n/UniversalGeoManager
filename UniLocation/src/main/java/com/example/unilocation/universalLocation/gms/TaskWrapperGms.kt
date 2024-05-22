package com.example.unilocation.universalLocation.gms

import android.app.Activity
import com.example.unilocation.universalLocation.OnCancelledListener
import com.example.unilocation.universalLocation.OnCompleteListener
import com.example.unilocation.universalLocation.OnFailureListener
import com.example.unilocation.universalLocation.OnSuccessListener
import com.example.unilocation.universalLocation.TaskWrapper
import com.google.android.gms.tasks.Task
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class TaskWrapperGms<Result>(
    private val task: Task<Result>
): TaskWrapper<Result> {

    override fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Result> {
        task.addOnCanceledListener(object : com.google.android.gms.tasks.OnCanceledListener{
            override fun onCanceled() = listener.onCanceled()
        })
        return this
    }

    override fun addOnCancelledListener(listener: OnCancelledListener, executor: Executor): TaskWrapper<Result> {
        task.addOnCanceledListener(executor, object : com.google.android.gms.tasks.OnCanceledListener{
            override fun onCanceled() = listener.onCanceled()
        })
        return this
    }

    override fun addOnCancelledListener(listener: OnCancelledListener, activity: Activity): TaskWrapper<Result> {
        task.addOnCanceledListener(activity, object : com.google.android.gms.tasks.OnCanceledListener{
            override fun onCanceled() = listener.onCanceled()
        })
        return this
    }

    override fun addOnCompleteListener(listener: OnCompleteListener<Result>): TaskWrapper<Result> {
        task.addOnCompleteListener(object : com.google.android.gms.tasks.OnCompleteListener<Result> {
            override fun onComplete(p0: Task<Result>) = listener.onComplete(p0)
        })
        return this
    }

    override fun addOnCompleteListener(listener: OnCompleteListener<Result>, executor: Executor): TaskWrapper<Result> {
        task.addOnCompleteListener(executor, object : com.google.android.gms.tasks.OnCompleteListener<Result> {
            override fun onComplete(p0: Task<Result>) = listener.onComplete(p0)
        })
        return this
    }

    override fun addOnCompleteListener(listener: OnCompleteListener<Result>, activity: Activity): TaskWrapper<Result> {
        task.addOnCompleteListener(activity, object : com.google.android.gms.tasks.OnCompleteListener<Result> {
            override fun onComplete(p0: Task<Result>) = listener.onComplete(p0)
        })
        return this
    }

    override fun addOnSuccessListener(listener: OnSuccessListener<in Result>): TaskWrapper<Result> {
        task.addOnSuccessListener(object : com.google.android.gms.tasks.OnSuccessListener<Result>{
            override fun onSuccess(p0: Result) = listener.onSuccess(p0)
        })
        return this
    }

    override fun addOnSuccessListener(listener: OnSuccessListener<in Result>, executor: Executor): TaskWrapper<Result> {
        task.addOnSuccessListener(executor, object : com.google.android.gms.tasks.OnSuccessListener<Result>{
            override fun onSuccess(p0: Result) = listener.onSuccess(p0)
        })
        return this
    }

    override fun addOnSuccessListener(listener: OnSuccessListener<in Result>, activity: Activity): TaskWrapper<Result> {
        task.addOnSuccessListener(activity, object : com.google.android.gms.tasks.OnSuccessListener<Result>{
            override fun onSuccess(p0: Result) = listener.onSuccess(p0)
        })
        return this
    }

    override fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Result> {
        task.addOnFailureListener(object : com.google.android.gms.tasks.OnFailureListener{
            override fun onFailure(p0: java.lang.Exception) = listener.onFailure(p0)
        })
        return this
    }

    override fun addOnFailureListener(listener: OnFailureListener, executor: Executor): TaskWrapper<Result> {
        task.addOnFailureListener(executor, object : com.google.android.gms.tasks.OnFailureListener{
            override fun onFailure(p0: java.lang.Exception) = listener.onFailure(p0)
        })
        return this
    }

    override fun addOnFailureListener(listener: OnFailureListener, activity: Activity): TaskWrapper<Result> {
        task.addOnFailureListener(activity, object : com.google.android.gms.tasks.OnFailureListener{
            override fun onFailure(p0: java.lang.Exception) = listener.onFailure(p0)
        })
        return this
    }

    override fun continueWith(
        executor: Executor,
        continuation: (kotlin.Result<Result>) -> Unit
    ): TaskWrapper<Result> {
        task.continueWith(executor) { task ->
            val result = if (task.isSuccessful)
                kotlin.Result.success(task.result)
            else
                kotlin.Result.failure(task.exception ?: Exception("Unknown error"))
            continuation(result)
        }
        return this
    }

    override fun <ContinuationResult> continueWithTask(
        executor: Executor,
        continuation: (kotlin.Result<Result>) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult> {
        val newTask = task.continueWithTask(executor) {task ->
            val result = if (task.isSuccessful)
                kotlin.Result.success(task.result)
            else
                kotlin.Result.failure(task.exception ?: Exception("Unknown error"))
            continuation(result).toGmsTask()

        }
        return TaskWrapperGms(newTask)
    }

    override fun <ContinuationResult> onSuccessTask(
        executor: Executor,
        continuation: (Result) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult> {
        val newTask = task.onSuccessTask(executor) {result ->
            continuation(result).toGmsTask()

        }
        return TaskWrapperGms(newTask)
    }

    override fun getResult(): Result? {
        return if (task.isSuccessful) {
            task.result
        } else {
            null
        }
    }

    override fun getException(): Exception? = task.exception

    override fun isCanceled(): Boolean = task.isCanceled

    override fun isComplete(): Boolean = task.isComplete

    override fun isSuccessful(): Boolean = task.isSuccessful

    private val executor: Executor = Executors.newSingleThreadExecutor()
    private fun <T> TaskWrapper<T>.toGmsTask(): com.google.android.gms.tasks.Task<T> {
        return com.google.android.gms.tasks.Tasks.call(executor) {
            this.getResult()
        }
    }
}
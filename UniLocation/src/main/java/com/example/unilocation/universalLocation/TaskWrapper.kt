package com.example.unilocation.universalLocation

import android.app.Activity
import java.util.concurrent.Executor

interface TaskWrapper<Result> {
    fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Result>
    fun addOnCancelledListener(listener: OnCancelledListener, executor: Executor): TaskWrapper<Result>
    fun addOnCancelledListener(listener: OnCancelledListener, activity: Activity): TaskWrapper<Result>
    fun addOnCompleteListener(listener: OnCompleteListener<Result>): TaskWrapper<Result>
    fun addOnCompleteListener(listener: OnCompleteListener<Result>, executor: Executor): TaskWrapper<Result>
    fun addOnCompleteListener(listener: OnCompleteListener<Result>, activity: Activity): TaskWrapper<Result>
    fun addOnSuccessListener(listener: OnSuccessListener<in Result>): TaskWrapper<Result>
    fun addOnSuccessListener(listener: OnSuccessListener<in Result>, executor: Executor): TaskWrapper<Result>
    fun addOnSuccessListener(listener: OnSuccessListener<in Result>, activity: Activity): TaskWrapper<Result>
    fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Result>
    fun addOnFailureListener(listener: OnFailureListener, executor: Executor): TaskWrapper<Result>
    fun addOnFailureListener(listener: OnFailureListener, activity: Activity): TaskWrapper<Result>
    fun getResult(): Result?
    fun getException(): Exception?
    fun isCanceled(): Boolean
    fun isComplete(): Boolean
    fun isSuccessful(): Boolean
    fun continueWith(executor: Executor, continuation: (kotlin.Result<Result>) -> Unit): TaskWrapper<Result>
    //fun continueWith(executor: Executor, continuation: Continuation<Result>): TaskWrapper<Result>
    fun <ContinuationResult> continueWithTask(
        executor: Executor,
        continuation: (kotlin.Result<Result>) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult>
    fun <ContinuationResult> onSuccessTask(
        executor: Executor,
        continuation: (Result) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult>
}

interface OnCancelledListener {
    fun onCanceled()
}

interface OnCompleteListener<Result> {
    fun onComplete(task: Any)
}

interface OnSuccessListener<Result> {
    fun onSuccess(result: Result)
}

interface OnFailureListener {
    fun onFailure(exception: Exception)
}
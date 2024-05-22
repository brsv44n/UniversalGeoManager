package com.example.unilocation.universalLocation.dls

import android.app.Activity
import com.example.unilocation.universalLocation.OnCancelledListener
import com.example.unilocation.universalLocation.OnCompleteListener
import com.example.unilocation.universalLocation.OnFailureListener
import com.example.unilocation.universalLocation.OnSuccessListener
import com.example.unilocation.universalLocation.TaskWrapper
import java.util.concurrent.Executor

class TaskWrapperDls<Result> : TaskWrapper<Result> {
    override fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnCancelledListener(
        listener: OnCancelledListener,
        executor: Executor
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnCancelledListener(
        listener: OnCancelledListener,
        activity: Activity
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnCompleteListener(listener: OnCompleteListener<Result>): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnCompleteListener(
        listener: OnCompleteListener<Result>,
        executor: Executor
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnCompleteListener(
        listener: OnCompleteListener<Result>,
        activity: Activity
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnSuccessListener(listener: OnSuccessListener<in Result>): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnSuccessListener(
        listener: OnSuccessListener<in Result>,
        executor: Executor
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnSuccessListener(
        listener: OnSuccessListener<in Result>,
        activity: Activity
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnFailureListener(
        listener: OnFailureListener,
        executor: Executor
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun addOnFailureListener(
        listener: OnFailureListener,
        activity: Activity
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun getResult(): Result? {
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
        continuation: (kotlin.Result<Result>) -> Unit
    ): TaskWrapper<Result> {
        TODO("Not yet implemented")
    }

    override fun <ContinuationResult> continueWithTask(
        executor: Executor,
        continuation: (kotlin.Result<Result>) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult> {
        TODO("Not yet implemented")
    }

    override fun <ContinuationResult> onSuccessTask(
        executor: Executor,
        continuation: (Result) -> TaskWrapper<ContinuationResult>
    ): TaskWrapper<ContinuationResult> {
        TODO("Not yet implemented")
    }
}
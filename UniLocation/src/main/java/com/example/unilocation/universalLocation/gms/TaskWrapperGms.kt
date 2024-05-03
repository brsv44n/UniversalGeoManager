package com.example.unilocation.universalLocation.gms

import com.example.unilocation.universalLocation.OnCancelledListener
import com.example.unilocation.universalLocation.OnCompleteListener
import com.example.unilocation.universalLocation.OnFailureListener
import com.example.unilocation.universalLocation.OnSuccessListener
import com.example.unilocation.universalLocation.TaskWrapper
import com.google.android.gms.tasks.Task

class TaskWrapperGms<Result>(
    private val task: Task<Result>
): TaskWrapper<Result> {

    override fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Result> {
        task.addOnCanceledListener(object : com.google.android.gms.tasks.OnCanceledListener{
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

    override fun addOnSuccessListener(listener: OnSuccessListener<in Result>): TaskWrapper<Result> {
        task.addOnSuccessListener(object : com.google.android.gms.tasks.OnSuccessListener<Result>{
            override fun onSuccess(p0: Result) = listener.onSuccess(p0)
        })
        return this
    }

    override fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Result> {
        task.addOnFailureListener(object : com.google.android.gms.tasks.OnFailureListener{
            override fun onFailure(p0: java.lang.Exception) = listener.onFailure()
        })
        return this
    }

    override fun getResult(): Result? {
        return if (task.isSuccessful) {
            task.result
        } else {
            null
        }
    }

    override fun getException(): Exception = task.let { it.exception!! }

    override fun isCanceled(): Boolean = task.isCanceled

    override fun isComplete(): Boolean = task.isComplete

    override fun isSuccessful(): Boolean = task.isSuccessful
}
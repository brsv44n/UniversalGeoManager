package com.example.unilocation.universalLocation

import com.huawei.hmf.tasks.Task

class TaskWrapperHms<Result>(
    private val task: Task<Result>
): TaskWrapper<Result> {
    override fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Result> {
        task.addOnCanceledListener(object : com.huawei.hmf.tasks.OnCanceledListener{
            override fun onCanceled() = listener.onCanceled()
        })
        return this
    }

    override fun addOnCompleteListener(listener: OnCompleteListener<Result>): TaskWrapper<Result> {
        task.addOnCompleteListener(object : com.huawei.hmf.tasks.OnCompleteListener<Result>{
            override fun onComplete(p0: Task<Result>) = listener.onComplete(p0)
        })
        return this
    }

    override fun addOnSuccessListener(listener: OnSuccessListener<in Result>): TaskWrapper<Result> {
        task.addOnSuccessListener(object : com.huawei.hmf.tasks.OnSuccessListener<Result>{
            override fun onSuccess(p0: Result) = listener.onSuccess(p0)
        })
        return this
    }

    override fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Result> {
        task.addOnFailureListener(object : com.huawei.hmf.tasks.OnFailureListener{
            override fun onFailure(p0: java.lang.Exception?) = listener.onFailure()
        })
        return this
    }

    override fun getResult(): Result = task.result

    override fun getException(): Exception = task.let { it.exception!! }

    override fun isCanceled(): Boolean = task.isCanceled

    override fun isComplete(): Boolean = task.isComplete

    override fun isSuccessful(): Boolean = task.isSuccessful
}
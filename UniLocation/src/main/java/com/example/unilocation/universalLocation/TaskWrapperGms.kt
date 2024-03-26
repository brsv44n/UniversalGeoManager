package com.example.unilocation.universalLocation

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
            /**
             * TODO и тут после добавления параметра в onFailure конвертить исключения тоже
             */
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

    /**
     * TODO Видимо тут нужно преобразовывать ResolvableApiException гугловский в ResolvableApiExceptionGms
     * (и в ResolvableApiExceptionHms в хуавейской реализации)
     * типа:
     * val exception = taskException ?: return null
     * if (exception is com.google.android.gms.common.api.ResolvableApiException) {
     *   return ResolvableApiExceptionGms(exception)
     * } else {
     *   return exception
     * }
     * Но у гугла и хуавея есть еще "свои" ApiException и UnsupportedApiCallException, их тоже надо завернуть в свои классы
     */
    override fun getException(): Exception = task.let { it.exception!! }

    override fun isCanceled(): Boolean = task.isCanceled

    override fun isComplete(): Boolean = task.isComplete

    override fun isSuccessful(): Boolean = task.isSuccessful
}
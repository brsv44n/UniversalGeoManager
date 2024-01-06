package com.example.universalgeomanager.universalLocation

interface TaskWrapper<Result> {
    fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Result>
    fun addOnCompleteListener(listener: OnCompleteListener<Result>): TaskWrapper<Result>
    fun addOnSuccessListener(listener: OnSuccessListener<in Result>): TaskWrapper<Result>
    fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Result>
    fun getResult(): Result?
    fun getException(): Exception
    fun isCanceled(): Boolean
    fun isComplete(): Boolean
    fun isSuccessful(): Boolean
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
    fun onFailure()
}
package com.example.unilocation.universalLocation

/**
 * TODO добавить еще перегрузки методов addOnCancelled(Complete/Success/Failure)Listener, которые принимают Executor/Activity вторым параметром
 * метод с Executor-ом нужен для того, чтобы задача выполнялась в другом потоке
 * метод с Activity нужен для того, чтобы лисенер учитывал жизненный цикл активити (для избежания утечек памяти)
 *  https://developers.google.com/android/guides/tasks тут чуть деталей есть, у хуавея смысл тот же
 */
interface TaskWrapper<Result> {
    fun addOnCancelledListener(listener: OnCancelledListener): TaskWrapper<Result>
    fun addOnCompleteListener(listener: OnCompleteListener<Result>): TaskWrapper<Result>
    fun addOnSuccessListener(listener: OnSuccessListener<in Result>): TaskWrapper<Result>
    fun addOnFailureListener(listener: OnFailureListener): TaskWrapper<Result>
    fun getResult(): Result?
    fun getException(): Exception //TODO тут скорее опциональным результат сделать. Исключения может не быть в случае успешного выполнения
    fun isCanceled(): Boolean
    fun isComplete(): Boolean
    fun isSuccessful(): Boolean

    //TODO возможно придется добавить и свои варианты для методов continueWith/continueWithTask/onSuccessTask
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
    fun onFailure() //TODO добавить параметр exception: Exception
}
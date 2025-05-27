package com.saydullin.domain.util.resource

sealed class Resource<T>(
    val data: T? = null,
    val status: StatusResource = Status.Unknown,
    val e: Throwable? = null,
    val message: String = "null",
) {

    companion object {
        fun <T> tryWith(statusType: StatusResource, scope: () -> T): Resource<T> {
            return try {
                Success(scope())
            } catch (e: Exception) {
                e.printStackTrace()
                Error(e, statusType)
            }
        }
        suspend fun <T> tryWithSuspend(statusType: StatusResource, scope: suspend () -> T): Resource<T> {
            return try {
                Success(scope())
            } catch (e: Exception) {
                e.printStackTrace()
                Error(e, statusType)
            }
        }
    }

    suspend fun onSuspendError(scope: suspend (Error<Unit>) -> Unit): T? {
        return if (isErrorData() || data == null) {
            scope(getError())
            null
        } else {
            data
        }
    }

    fun getStatusAndMessage(): String {
        return "$status, $message"
    }

    fun getOrNull(): T? {
        return if (isErrorData() || data == null) null else data
    }

    fun getOrThrow(scope: (Error<Unit>) -> Throwable): T {
        if (isErrorData() || data == null) {
            val throwable = try {
                scope(getError())
            } catch (e: Exception) {
                e
            }

            throw throwable
        }

        return data
    }

    fun onError(scope: (Error<Unit>) -> Unit): T? {
        return if (isErrorData() || data == null) {
            scope(getError())

            null
        } else {
            data
        }
    }

    fun isSuccessData(): Boolean {
        return this is Success<T> && this.data != null
    }

    fun isErrorData(): Boolean {
        return this is Error
    }

    fun <T> getError(): Error<T> {
        return Error(
            e = this.e,
            status = this.status,
            message = this.message,
        )
    }

    class Success<T>(
        data: T?
    ): Resource<T>(data)

    class Error<T>(
        e: Throwable? = null,
        status: StatusResource = Status.Unknown,
        message: String = "null",
        data: T? = null
    ): Resource<T>(data, status, e, message) {

        companion object {
            fun <T> successType() = Error<T>(
                status = Status.Success
            )
        }

    }

}
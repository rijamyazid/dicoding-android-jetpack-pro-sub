package com.example.jetpack_submissions.data.source.local

class LocalResponses<T>(val status: LocalStatus, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): LocalResponses<T> =
            LocalResponses(LocalStatus.SUCCESS, data, null)

        fun <T> error(msg: String?, data: T?): LocalResponses<T> =
            LocalResponses(LocalStatus.ERROR, data, msg)

        fun <T> loading(data: T?): LocalResponses<T> =
            LocalResponses(LocalStatus.LOADING, data, null)
    }

}
package com.example.jetpack_submissions.data.source.remote

class RemoteResponses<T>(val status: RemoteStatus, val data: T, val message: String?) {

    companion object {
        fun <T> success(data: T): RemoteResponses<T> =
            RemoteResponses(RemoteStatus.SUCCESS, data, null)

        fun <T> empty(msg: String?, data: T): RemoteResponses<T> =
            RemoteResponses(RemoteStatus.EMPTY, data, msg)

        fun <T> error(msg: String?, data: T): RemoteResponses<T> =
            RemoteResponses(RemoteStatus.ERROR, data, msg)
    }

}
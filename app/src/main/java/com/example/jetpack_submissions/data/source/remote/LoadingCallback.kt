package com.example.jetpack_submissions.data.source.remote

import com.example.jetpack_submissions.data.ConnectionStatus

interface LoadingCallback {
    fun isOnLoadingState(status: Boolean)
    fun isConnectionSuccesfull(status: ConnectionStatus)
}
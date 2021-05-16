package com.example.jetpack_submissions.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.remote.RemoteResponses
import com.example.jetpack_submissions.data.source.remote.RemoteStatus
import com.example.jetpack_submissions.utils.AppExecutors
import com.example.jetpack_submissions.utils.EspressoIdlingResource

abstract class NetworkBoundResource<LocalData, RemoteData>(private val mExecutors: AppExecutors) {

    private val result = MediatorLiveData<LocalResponses<LocalData>>()

    init {
        result.value = LocalResponses.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) { data ->
            EspressoIdlingResource.increment()
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                EspressoIdlingResource.decrement()
                result.addSource(dbSource) { newData ->
                    result.value = LocalResponses.success(newData)
                }
            }
        }
    }

    protected fun onFetchFailed() {}

    protected abstract fun loadFromDB(): LiveData<LocalData>

    protected abstract fun shouldFetch(data: LocalData?): Boolean

    protected abstract fun createCall(): LiveData<RemoteResponses<RemoteData>>

    protected abstract fun saveCallResult(data: RemoteData)

    private fun fetchFromNetwork(dbSource: LiveData<LocalData>) {

        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = LocalResponses.loading(newData)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response.status) {
                RemoteStatus.SUCCESS ->
                    mExecutors.diskIO().execute {
                        saveCallResult(response.data)
                        mExecutors.mainThread().execute {
                            EspressoIdlingResource.decrement()
                            result.addSource(loadFromDB()) { newData ->
                                result.value = LocalResponses.success(newData)
                            }
                        }
                    }
                RemoteStatus.EMPTY -> mExecutors.mainThread().execute {
                    EspressoIdlingResource.decrement()
                    result.addSource(loadFromDB()) { newData ->
                        result.value = LocalResponses.success(newData)
                    }
                }
                RemoteStatus.ERROR -> {
                    onFetchFailed()
                    EspressoIdlingResource.decrement()
                    result.addSource(dbSource) { newData ->
                        result.value = LocalResponses.error(response.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<LocalResponses<LocalData>> = result
}
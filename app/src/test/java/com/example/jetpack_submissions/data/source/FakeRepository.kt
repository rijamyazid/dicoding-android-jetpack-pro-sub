package com.example.jetpack_submissions.data.source

//class FakeRepository(private val remoteDataSource: RemoteDataSource) : DataSource {

//    override fun getAllRemoteMovies(): LiveData<ArrayList<MovieItem>> {
//        val remoteMoviesResult = MutableLiveData<ArrayList<MovieItem>>()
//        remoteDataSource.getAllRemoteMovies(object : RemoteDataSource.LoadMoviesCallback {
//            override fun onAllMoviesReceived(moviesResponses: ArrayList<MovieItem>) {
//                remoteMoviesResult.value = moviesResponses
//            }
//        })
//        return remoteMoviesResult
//    }
//
//    override fun getAllRemoteTVShows(): LiveData<ArrayList<TVShowItem>> {
//        val remoteTVShowsResult = MutableLiveData<ArrayList<TVShowItem>>()
//        remoteDataSource.getAllRemoteTVShows(object : RemoteDataSource.LoadTVShowCallback {
//            override fun onAllTVShowsReceived(tvshowResponses: ArrayList<TVShowItem>) {
//                remoteTVShowsResult.value = tvshowResponses
//            }
//        })
//        return remoteTVShowsResult
//    }

//}
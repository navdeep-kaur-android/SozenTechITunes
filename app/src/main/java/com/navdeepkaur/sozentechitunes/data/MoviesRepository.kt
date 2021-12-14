package com.navdeepkaur.sozentechitunes.data

import com.navdeepkaur.sozentechitunes.data.local.ResultsDao
import com.navdeepkaur.sozentechitunes.data.local.asDomainModel
import com.navdeepkaur.sozentechitunes.data.network.IApiServices
import com.navdeepkaur.sozentechitunes.data.network.Movies
import com.navdeepkaur.sozentechitunes.data.network.Results
import com.navdeepkaur.sozentechitunes.data.network.asDatabaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Navdeep Kaur on 12/12/2021
 * navdeep.kaur36026@gmail.com
 */
class MoviesRepository(private val resultsDao : ResultsDao, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
                       private val apiService : IApiServices
) : IDataSource {

    override suspend fun getMovies(data: String): Movies=  withContext(ioDispatcher){
           val list = apiService.getMovies(data)
            resultsDao.addMoviesLocally(list.results.asDatabaseModel())
            list
    }

    override suspend fun getLocalMovies(data: String): List<Results> = withContext(ioDispatcher){
        resultsDao.retrieveLocalMovies(data).asDomainModel()
    }

}
package com.navdeepkaur.sozentechitunes.data

import com.navdeepkaur.sozentechitunes.data.network.Movies
import com.navdeepkaur.sozentechitunes.data.network.Results

/**
 * Created by Navdeep Kaur on 12/13/2021
 * navdeep.kaur36026@gmail.com
 */
interface IDataSource {
    suspend fun getMovies(data: String): Movies
    suspend fun getLocalMovies(data: String) : List<Results>

}
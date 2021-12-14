package com.navdeepkaur.sozentechitunes.data.local

/**
 * Created by Navdeep Kaur on 12/12/2021
 * navdeep.kaur36026@gmail.com
 */
interface ResultsDao {
    fun addMoviesLocally(results: List<DatabaseResults>): Boolean
    fun retrieveLocalMovies(data : String): List<DatabaseResults>
}
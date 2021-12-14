package com.navdeepkaur.sozentechitunes.data.network

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Navdeep Kaur on 12/11/2021
 * navdeep.kaur36026@gmail.com
 */
interface IApiServices {
    @GET("search?")
    suspend fun getMovies(@Query("term") search:String?,
                          @Query("media") media:String? = "movie",
    @Query("attribute") attribute: String? = "movieTerm",
    @Query("limit") limit:String? = "20"): Movies
}
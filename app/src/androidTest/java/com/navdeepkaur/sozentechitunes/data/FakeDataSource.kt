package com.navdeepkaur.sozentechitunes.data


import com.navdeepkaur.sozentechitunes.data.network.Movies
import com.navdeepkaur.sozentechitunes.data.network.Results


//Use FakeDataSource that acts as a test double to the DataSource/Repository
class FakeDataSource(private var results : MutableList<Results>? = mutableListOf()) : IDataSource {
    private var shouldReturnEmpty= false

    fun setReturnEmpty(value: Boolean) {
        shouldReturnEmpty = value
    }

    override suspend fun getMovies(data: String): Movies {
        if(shouldReturnEmpty)
            return Movies(0, emptyList())
        results?.let { return Movies(results!!.size, results!!) }
        return Movies(0, emptyList())
    }

    override suspend fun getLocalMovies(data: String): List<Results> {
        if(shouldReturnEmpty)
            return emptyList()
        results?.let { return ArrayList(it)}
        return emptyList()
    }


}
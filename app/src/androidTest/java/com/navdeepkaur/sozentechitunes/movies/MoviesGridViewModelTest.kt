package com.navdeepkaur.sozentechitunes.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.navdeepkaur.sozentechitunes.data.FakeDataSource
import com.navdeepkaur.sozentechitunes.util.getOrAwaitValue
import com.navdeepkaur.sozentechitunes.util.createResultsList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Navdeep Kaur on 12/14/2021
 * navdeep.kaur36026@gmail.com
 */
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class MoviesGridViewModelTest {
    private val list = createResultsList()
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var dataSource: FakeDataSource
    private lateinit var viewModel: MoviesGridViewModel
    @Before
    fun setUpViewModel() {
        dataSource = FakeDataSource(list)
        viewModel = MoviesGridViewModel(ApplicationProvider.getApplicationContext(), dataSource)
    }



    /**
     * Method to show error in case of empty list
     */
    @Test
    fun shouldReturnEmpty() {
        dataSource.setReturnEmpty(true)
        viewModel.searchMovies()
        val showNoData = viewModel.showNoData.getOrAwaitValue()
        assert(showNoData)
    }

    /**
     * Method to check if view model is not missing any data
     */
    @Test
    fun checkSizeofMoviesList() {
        viewModel.searchMovies()
        val reminderList = viewModel.movieList.getOrAwaitValue()
        MatcherAssert.assertThat(reminderList.size, CoreMatchers.`is`(list.size))
    }

    /**
     * Method to check if data is returned same as data provided by data source
     */
    @Test
    fun checkShowNoData() {
        viewModel.searchMovies()
        val data = viewModel.movieList.value?.get(0)
        val provideData = list[0]
        data?.let {
            MatcherAssert.assertThat(it.trackName, CoreMatchers.`is`(provideData.trackName))
            MatcherAssert.assertThat(it.trackPrice, CoreMatchers.`is`(provideData.trackPrice))
            MatcherAssert.assertThat(it.trackRentalPrice, CoreMatchers.`is`(provideData.trackRentalPrice))
            MatcherAssert.assertThat(it.trackId, CoreMatchers.`is`(provideData.trackId))
            MatcherAssert.assertThat(it.primaryGenreName, CoreMatchers.`is`(provideData.primaryGenreName))
            MatcherAssert.assertThat(it.previewUrl, CoreMatchers.`is`(provideData.previewUrl))
            MatcherAssert.assertThat(it.longDescription, CoreMatchers.`is`(provideData.longDescription))
            MatcherAssert.assertThat(it.kind, CoreMatchers.`is`(provideData.kind))
            MatcherAssert.assertThat(it.trackCensoredName, CoreMatchers.`is`(provideData.trackCensoredName))
            MatcherAssert.assertThat(it.artistName, CoreMatchers.`is`(provideData.artistName))
            MatcherAssert.assertThat(it.currency, CoreMatchers.`is`(provideData.currency))
            MatcherAssert.assertThat(it.country, CoreMatchers.`is`(provideData.country))
        }

    }

}
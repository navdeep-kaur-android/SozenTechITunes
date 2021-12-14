package com.navdeepkaur.sozentechitunes.movies

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.navdeepkaur.sozentechitunes.R
import com.navdeepkaur.sozentechitunes.base.BaseViewModel
import com.navdeepkaur.sozentechitunes.data.IDataSource
import com.navdeepkaur.sozentechitunes.data.network.Results
import com.navdeepkaur.sozentechitunes.utils.isNetworkAvailable
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


/**
 * Created by Navdeep Kaur on 12/11/2021
 * navdeep.kaur36026@gmail.com
 */
class MoviesGridViewModel(private val app: Application,
                          private val dataSource: IDataSource) :
    BaseViewModel(app) {


    private val _movieList = MutableLiveData<List<Results>>()
    private lateinit var job: Job
    private var jobRunning = false
    val movieList: LiveData<List<Results>>
        get() = _movieList
    init {
        showLoading.value = true
        searchMovies()
    }

    fun searchMovies(search: String = "") {
        if (jobRunning) {
            job.cancel()
        }
        job = viewModelScope.launch {
            jobRunning = true
            try {
                _movieList.value = if (app.isNetworkAvailable()) {
                    val data = dataSource.getMovies(search)
                    data.results
                } else {
                    showSnackBarInt.value = R.string.network_unavailable
                    dataSource.getLocalMovies(search)
                }
            } catch (ex: CancellationException) {
                //We will ignore cancellation exception
            }catch (ex: Exception) {
                    showErrorMessage.value = ex.message
                }
            showNoData.value = _movieList.value?.isEmpty()?: true
            showLoading.value = false
            jobRunning = false
        }
        }
    }

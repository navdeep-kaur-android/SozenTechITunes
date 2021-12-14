package com.navdeepkaur.sozentechitunes.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.navdeepkaur.sozentechitunes.utils.SingleLiveEvent

/**
 * Created by Navdeep Kaur on 12/11/2021
 * navdeep.kaur36026@gmail.com
 */
abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {
    val showErrorMessage: SingleLiveEvent<String> = SingleLiveEvent()
    val showSnackBar: SingleLiveEvent<String> = SingleLiveEvent()
    val showSnackBarInt: SingleLiveEvent<Int> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()
    val showLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showNoData: MutableLiveData<Boolean> = MutableLiveData()
}
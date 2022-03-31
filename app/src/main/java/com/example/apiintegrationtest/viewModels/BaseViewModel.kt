package com.example.apiintegrationtest.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiintegrationtest.NavigationRoute

open class BaseViewModel() : ViewModel() {

    private val navigationId = MutableLiveData<NavigationRoute>()
    val navigation: LiveData<NavigationRoute> = navigationId

    private val mMessage = MutableLiveData<String>()
    val message: LiveData<String> = mMessage

    fun navigateTo(destination: NavigationRoute) {
        navigationId.postValue(destination)
    }

    fun showSimpleMessage(message: String) {
        mMessage.postValue(message)
    }

    open fun OnResume() {

    }

    open fun OnStop() {

    }

}
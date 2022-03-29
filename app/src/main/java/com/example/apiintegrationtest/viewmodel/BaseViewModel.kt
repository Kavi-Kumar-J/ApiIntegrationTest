package com.example.apiintegrationtest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    open fun OnResume() {

    }

    open fun OnStop() {

    }

}
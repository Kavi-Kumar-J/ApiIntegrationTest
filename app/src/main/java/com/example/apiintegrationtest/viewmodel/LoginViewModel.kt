package com.example.apiintegrationtest.viewmodel

import APIs.IUserService
import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.example.apiintegrationtest.BR
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    application: Application,
    userService: IUserService
) : BaseViewModel(application) {

    val userName = ObservableField<String>()
    val password = ObservableField<String>()

    fun OnSigninClicked() {
        Toast.makeText(getApplication(), "signin", Toast.LENGTH_SHORT)
    }

    fun OnSignUpClicked() {

    }

}

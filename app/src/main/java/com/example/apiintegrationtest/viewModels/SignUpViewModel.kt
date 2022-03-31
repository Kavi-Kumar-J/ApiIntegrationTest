package com.example.apiintegrationtest.viewModels

import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableField
import com.example.apiintegrationtest.NavigationRoute
import com.example.apiintegrationtest.data.SignUpRequest
import com.example.apiintegrationtest.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : BaseViewModel() {

    val userName = ObservableField<String>()
    val email = ObservableField<String>()
    val password = ObservableField<String>()

    fun onSignUpClicked() {

        if (userName.get().isNullOrEmpty() ||
            email.get().isNullOrEmpty() ||
            password.get().isNullOrEmpty()
        )
            return

        var signUpRequest = SignUpRequest(
            userName.get().toString(),
            email.get().toString(),
            password.get().toString()
        )

        userRepository.userSignUp(signUpRequest).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                Consumer {
                    if (it.isSuccess) {
                        showSimpleMessage(it.data)
                        navigateTo(NavigationRoute.SignUpToSignIn)
                    }
                },
                Consumer {
                    it.message?.let { it1 -> showSimpleMessage(it1) }
                }
            )
    }

    fun onSignInClicked() {
        navigateTo(NavigationRoute.SignUpToSignIn)
    }

}
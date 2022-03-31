package com.example.apiintegrationtest.viewModels

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.example.apiintegrationtest.NavigationRoute
import com.example.apiintegrationtest.data.SignInRequest
import com.example.apiintegrationtest.dataStore.DataStoreManager
import com.example.apiintegrationtest.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val dataStoreManager: DataStoreManager,
) : BaseViewModel() {

    val email = ObservableField<String>()
    val password = ObservableField<String>()

    init {
    }

    fun onSignInClicked() {

        viewModelScope.launch {
            var token = dataStoreManager.token.collect {
                if (!it.isNullOrEmpty()) showSimpleMessage("Already signed in $it")
            }
        }

        if (email.get().isNullOrEmpty() || password.get().isNullOrEmpty())
            return

        var signInRequest = SignInRequest(email.get()!!, password.get()!!)
        userRepository.userSignIn(signInRequest).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
                Consumer {
                    viewModelScope.launch {
                        if (it.isSuccess) {
                            dataStoreManager.saveToken(it.data)
                            navigateTo(NavigationRoute.SignInToDash)
                        } else {
                            showSimpleMessage(it.errors[0])
                        }
                    }
                },
                Consumer {
                    it.message?.let { msg -> showSimpleMessage(msg) }
                }
            )

    }

    fun onSignUpClicked() {
        navigateTo(NavigationRoute.SignInToSignUp)
    }

}

package com.example.apiintegrationtest.repository.interfaces

import com.example.apiintegrationtest.ResponseModel
import com.example.apiintegrationtest.data.*
import io.reactivex.Observable

interface IUserRepository {
    fun userSignIn(signInRequest: SignInRequest): Observable<ResponseModel<String>>
    fun userSignUp(signUpRequest: SignUpRequest): Observable<ResponseModel<String>>
}
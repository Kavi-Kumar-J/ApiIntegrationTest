package com.example.apiintegrationtest.repository

import com.example.apiintegrationtest.ResponseModel
import com.example.apiintegrationtest.apiServices.IUserService
import com.example.apiintegrationtest.data.*
import com.example.apiintegrationtest.repository.interfaces.IUserRepository
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() : IUserRepository {

    @Inject
    lateinit var userService: IUserService

    override fun userSignUp(signUpRequest: SignUpRequest): Observable<ResponseModel<String>> {

        return userService.signup(signUpRequest)
    }

    override fun userSignIn(signInRequest: SignInRequest): Observable<ResponseModel<String>> {

        return userService.signIn(signInRequest)
    }

}
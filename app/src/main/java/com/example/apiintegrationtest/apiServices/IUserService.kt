package com.example.apiintegrationtest.apiServices

import com.example.apiintegrationtest.ResponseModel
import com.example.apiintegrationtest.data.*
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface IUserService {

    @POST("/api/login")
//    fun signIn(@Body body: SignInRequest): Observable<ResponseModel<SignInResponse>>
    fun signIn(@Body body: SignInRequest): Observable<ResponseModel<String>>

    @Headers("Accept: application/json")
    @POST("/api/signup")
//    fun signup(@Body body: SignUpRequest): Observable<ResponseModel<SignUpResponse>>
    fun signup(@Body body: SignUpRequest): Observable<ResponseModel<String>>

}
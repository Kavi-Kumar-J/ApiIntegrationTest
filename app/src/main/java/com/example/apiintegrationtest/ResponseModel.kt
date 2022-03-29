package com.example.apiintegrationtest

class ResponseModel<T>(
    private val isSuccess: Boolean,
    private val data: T,
    private val message: String
) {

}
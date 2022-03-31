package com.example.apiintegrationtest

class ResponseModel<T>(
    val isSuccess: Boolean,
    val data: T,
    val errors: List<String>
) {

}
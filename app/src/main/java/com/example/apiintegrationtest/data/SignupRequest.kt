package com.example.apiintegrationtest.data

data class SignUpRequest(
    private val username: String,
    private val email: String,
    private val password: String
)
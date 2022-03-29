package com.example.apiintegrationtest.data

data class UserData(val username: String, val firstName: String, val lastName: String)
data class Signin(val username: String, var password: String)
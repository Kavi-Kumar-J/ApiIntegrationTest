package com.example.apiintegrationtest.dagger

import APIs.IUserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    val BASE_URL = "https://api-with-mongodb.heroku.com/"

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{

        return Retrofit.Builder().
        baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit) : IUserService{
        return retrofit.create(IUserService::class.java)
    }

}
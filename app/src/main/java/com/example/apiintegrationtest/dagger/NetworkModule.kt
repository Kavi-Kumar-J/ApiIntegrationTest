package com.example.apiintegrationtest.dagger

import com.example.apiintegrationtest.apiServices.IUserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    private val baseUrl = "https://api-with-mongodb.herokuapp.com/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit): IUserService {
        return retrofit.create(IUserService::class.java)
    }

}
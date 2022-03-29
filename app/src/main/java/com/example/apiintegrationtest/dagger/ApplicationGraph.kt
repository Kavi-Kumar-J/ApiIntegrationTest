package com.example.apiintegrationtest.dagger

import com.example.apiintegrationtest.MainActivity
import com.example.apiintegrationtest.viewmodel.LoginViewModel
import com.example.apiintegrationtest.MyApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MainActivityModule::class, AppModule::class, NetworkModule::class))
interface ApplicationGraph {
    fun inject(application: MyApplication)
    fun inject(mainActivity : MainActivity)
}
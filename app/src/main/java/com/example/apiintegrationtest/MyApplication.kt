package com.example.apiintegrationtest

import android.app.Application
import com.example.apiintegrationtest.dagger.AppModule
import com.example.apiintegrationtest.dagger.ApplicationGraph
import com.example.apiintegrationtest.dagger.DaggerApplicationGraph
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    private lateinit var applicationGraph: ApplicationGraph

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        applicationGraph =
            DaggerApplicationGraph.builder().appModule(AppModule(this))
                .build()
        applicationGraph.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

}
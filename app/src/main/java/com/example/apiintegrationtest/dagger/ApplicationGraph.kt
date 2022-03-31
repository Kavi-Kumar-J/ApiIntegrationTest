package com.example.apiintegrationtest.dagger

import com.example.apiintegrationtest.MainActivity
import com.example.apiintegrationtest.viewModels.SignInViewModel
import com.example.apiintegrationtest.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ActivityModule::class,
        AppModule::class,
        NetworkModule::class,
        FragmentModule::class]
)
interface ApplicationGraph {
    fun inject(application: MyApplication)
    fun inject(mainActivity: MainActivity)
}
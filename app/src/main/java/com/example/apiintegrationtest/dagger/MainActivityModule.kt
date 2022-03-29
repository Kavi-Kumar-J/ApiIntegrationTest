package com.example.apiintegrationtest.dagger

import com.example.apiintegrationtest.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [IMainActivitySubComponent::class])
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bind(subFac : IMainActivitySubComponent.Factory) : AndroidInjector.Factory<*>?
}
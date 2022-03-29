package com.example.apiintegrationtest.dagger

import com.example.apiintegrationtest.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface IMainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface  Factory : AndroidInjector.Factory<MainActivity>{}
}
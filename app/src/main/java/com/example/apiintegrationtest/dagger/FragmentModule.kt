package com.example.apiintegrationtest.dagger

import com.example.apiintegrationtest.fragments.DashboardFragment
import com.example.apiintegrationtest.fragments.SignInFragment
import com.example.apiintegrationtest.fragments.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeSignInFrag(): SignInFragment

    @ContributesAndroidInjector
    abstract fun contributeSignUpFrag(): SignUpFragment

    @ContributesAndroidInjector
    abstract fun contributeDashboardFrag(): DashboardFragment
}
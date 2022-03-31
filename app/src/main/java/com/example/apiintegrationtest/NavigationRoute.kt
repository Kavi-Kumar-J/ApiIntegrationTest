package com.example.apiintegrationtest

import androidx.annotation.IdRes

sealed class NavigationRoute(@IdRes open val destination: Int) {
    object Back : NavigationRoute(-1)

    object SignInToSignUp : NavigationRoute(R.id.action_signInFragment_to_signUpFragment)
    object SignUpToSignIn : NavigationRoute(R.id.action_signUpFragment_to_signInFragment)
    object SignInToDash : NavigationRoute(R.id.action_signInFragment_to_dashboardFragment)
}

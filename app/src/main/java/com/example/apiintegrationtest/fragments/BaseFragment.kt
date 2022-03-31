package com.example.apiintegrationtest.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.apiintegrationtest.NavigationRoute
import com.example.apiintegrationtest.viewModels.BaseViewModel
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    abstract val bindingVM: BaseViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureNavigation()
        configureMessaging()
    }

    private fun configureMessaging() {
        bindingVM.message.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT)
                .show()
        })
    }

    private fun configureNavigation() {
        bindingVM.navigation.observe(viewLifecycleOwner, Observer { id ->
            navigateTo(id)
        })
    }

    private fun navigateTo(route: NavigationRoute) {
        when (route) {
            is NavigationRoute.Back -> findNavController().popBackStack()
            else -> findNavController().navigate(route.destination)
        }
    }

}
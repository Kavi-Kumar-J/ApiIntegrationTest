package com.example.apiintegrationtest.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.apiintegrationtest.R
import com.example.apiintegrationtest.databinding.DashboardFragmentBinding
import com.example.apiintegrationtest.databinding.SignInFragmentBinding
import com.example.apiintegrationtest.viewModels.BaseViewModel
import com.example.apiintegrationtest.viewModels.DashboardViewModel
import javax.inject.Inject

class DashboardFragment : BaseFragment() {

    companion object {
        fun newInstance() = DashboardFragment()
    }

    @Inject
    lateinit var viewModel: DashboardViewModel
    override val bindingVM: BaseViewModel
        get() = viewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<DashboardFragmentBinding>(
            inflater,
            R.layout.dashboard_fragment,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel
        return binding.root
    }


}
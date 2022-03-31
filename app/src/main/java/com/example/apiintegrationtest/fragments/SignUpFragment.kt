package com.example.apiintegrationtest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.apiintegrationtest.R
import com.example.apiintegrationtest.databinding.SignInFragmentBinding
import com.example.apiintegrationtest.databinding.SignUpFragmentBinding
import com.example.apiintegrationtest.viewModels.BaseViewModel
import com.example.apiintegrationtest.viewModels.SignUpViewModel
import javax.inject.Inject

class SignUpFragment : BaseFragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    @Inject
    lateinit var viewModel: SignUpViewModel
    override val bindingVM: BaseViewModel
        get() = viewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<SignUpFragmentBinding>(
            inflater,
            R.layout.sign_up_fragment,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel
        return binding.root
    }


}
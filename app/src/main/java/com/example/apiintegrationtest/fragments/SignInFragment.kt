package com.example.apiintegrationtest.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.apiintegrationtest.R
import com.example.apiintegrationtest.databinding.SignInFragmentBinding
import com.example.apiintegrationtest.viewModels.BaseViewModel
import com.example.apiintegrationtest.viewModels.SignInViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SignInFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: SignInViewModel

    companion object {
        fun newInstance() = SignInFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<SignInFragmentBinding>(
            inflater,
            R.layout.sign_in_fragment,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel
        return binding.root
    }

    override val bindingVM: BaseViewModel
        get() = viewModel


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}
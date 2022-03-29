package com.example.apiintegrationtest

import androidx.appcompat.app.AppCompatActivity
import com.example.apiintegrationtest.viewmodel.BaseViewModel

abstract class BaseActivity  : AppCompatActivity() {

     lateinit var viewmodelBase : BaseViewModel
    override fun onResume() {
        super.onResume()

    }

}
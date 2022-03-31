package com.example.apiintegrationtest

import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dagger.android.AndroidInjection

class MainActivity : BaseActivity() {


    private lateinit var fragmentContainer: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        fragmentContainer =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, fragmentContainer.navController)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
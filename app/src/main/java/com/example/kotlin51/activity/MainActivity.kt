package com.example.kotlin51.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlin51.R
import com.example.kotlin51.preference.PrefernceHelper

class MainActivity : AppCompatActivity() {
    private val preferenceHelper: PrefernceHelper by lazy {
        PrefernceHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation(savedInstanceState)
    }

    private fun setupNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

            if (!preferenceHelper.isShowRegister){
                navGraph.setStartDestination(R.id.registrationFragment)
                navController.graph = navGraph
            }
        }
    }
}
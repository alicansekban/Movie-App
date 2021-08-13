package com.alican.testapp.ui.main

import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.alican.testapp.R
import com.alican.testapp.core.BaseActivity
import com.alican.testapp.databinding.ActivityMainBinding
import com.alican.testapp.utils.util.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(MainViewModel::class.java) {
    private var navController: LiveData<NavController>? = null

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onInit() {
        initNavigation()

    }

    private fun initNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val navGraphIds = listOf(
            R.navigation.main_graph
        )
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.container,
            intent = intent
        )
        navController = controller
        navController?.observe(this, { navController ->
            // setupActionBarWithNavController(navController)
        })

        binding.bottomNavigation.selectedItemId = R.id.main_graph
    }

    private fun doNavigateUp() {
        navController?.value?.navigateUp()
    }

    override fun onBackPressed() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        when (navHostFragment.navController.currentDestination?.id) {
            R.id.homeFragment -> {
                super.onBackPressed()
            }
            else -> {
                doNavigateUp()
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val navController = findNavController(R.id.container)
        item.let { NavigationUI.onNavDestinationSelected(it, navController) }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.container).navigateUp()
}
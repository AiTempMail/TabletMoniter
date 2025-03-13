package com.example.tabletmonitor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tabletmonitor.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate started")

        try {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding?.root ?: throw IllegalStateException("Binding root is null"))
            Log.d(TAG, "Layout inflated successfully")

            val navView: BottomNavigationView = binding?.bottomNavigation
                ?: throw IllegalStateException("BottomNavigationView not found")

            val navController = try {
                findNavController(R.id.nav_host_fragment)
            } catch (e: IllegalStateException) {
                Log.e(TAG, "NavController not found for nav_host_fragment: ${e.message}", e)
                finish()
                return
            }

            navView.setupWithNavController(navController)
            Log.d(TAG, "Navigation setup completed successfully")

        } catch (e: Exception) {
            Log.e(TAG, "Error in onCreate: ${e.message}", e)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        Log.d(TAG, "onDestroy called")
    }
}
package com.example.mindteck.fragments.main

import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.example.mindteck.R

class MainHostFragment : NavHostFragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: homeHost")
        navController.apply {
            graph = navInflater.inflate(R.navigation.nav_main)
        }
    }

    companion object{
        const val TAG = "fragmentTest"
    }
}
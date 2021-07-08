package com.example.mindteck.fragments.main

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mindteck.fragments.Banks.BanksFragment
import com.example.mindteck.fragments.fruits.FruitsFragment
import com.example.mindteck.fragments.heroes.HeroesFragment
import java.util.HashMap

class MainAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3
    val ref = HashMap<Int, Fragment>()

    init {
        ref[0] = HeroesFragment()
        ref[1] = BanksFragment()
        ref[2] = FruitsFragment()
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        Log.d(MainHostFragment.TAG, "adapter => createFragment: $position")
        return ref[position]!!
    }

    companion object {
        const val TAG = "fragment_test"
    }
}
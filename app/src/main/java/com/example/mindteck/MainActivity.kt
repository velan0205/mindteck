package com.example.mindteck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.mindteck.databinding.ActivityMainBinding
import com.example.mindteck.fragments.main.MainHostFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        const val MAIN_TAG = "main_fragment"

        @BindingAdapter("app:appSetImageIcon")
        @JvmStatic
        fun appSetImageIcon(view: ImageView, resource: Int) {
            view.setImageResource(resource)
        }
    }

    lateinit var binding: ActivityMainBinding
    var currentHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, null, false)
        setContentView(binding.root)
        //setSupportActionBar(binding.toolbar)

        currentHostFragment = MainHostFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, currentHostFragment!!, MAIN_TAG).commit()

        binding.executePendingBindings()
    }
}
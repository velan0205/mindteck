package com.example.mindteck.fragments.Banks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mindteck.databinding.FragmentBanksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BanksFragment:Fragment() {
    lateinit var binding: FragmentBanksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBanksBinding.inflate(inflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
package com.example.mindteck.fragments.fruits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mindteck.databinding.FragmentsFruitsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FruitsFragment : Fragment() {
    lateinit var binding: FragmentsFruitsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentsFruitsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
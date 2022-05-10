package com.example.mycontactlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mycontactlist.databinding.FragmentDisplayContactBinding


class DisplayContactFragment : Fragment() {

    lateinit var binding: FragmentDisplayContactBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisplayContactBinding.inflate(inflater, container, false)
        return binding.root
    }
}
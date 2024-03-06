package com.example.foursquare.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.foursquare.R
import com.example.foursquare.databinding.AuthFragmentBinding
import com.example.foursquare.presentation.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AuthFragment: Fragment(R.layout.auth_fragment) {

    private val viewModel: LoginViewModel by viewModels()
    lateinit var binding : AuthFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AuthFragmentBinding.bind(view)
        init()
        initObserver()
    }

    fun init(){
        binding.buttonConnectToFOURSQUARE.setOnClickListener{
            viewModel.login()
        }
        binding.buttonDontLogin.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_containerFragment)
        }
    }


    fun initObserver(){
        lifecycleScope.launch {
            viewModel.login.collect{
                if (it) {
                    findNavController().navigate(R.id.action_authFragment_to_containerFragment)
                }
            }
        }
    }
}
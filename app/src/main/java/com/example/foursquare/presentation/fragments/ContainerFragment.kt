package com.example.foursquare.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.foursquare.R
import com.example.foursquare.databinding.ContainerFragmentBinding
import com.example.foursquare.domain.useCase.DeleteHistoryUseCase
import com.example.foursquare.domain.useCase.LogoutUseCase
import com.example.foursquare.presentation.viewModel.ContainerViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ContainerFragment : Fragment(R.layout.container_fragment) {

    lateinit var binding: ContainerFragmentBinding
    private val viewModel: ContainerViewModel by  viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ContainerFragmentBinding.bind(view)

        val navController =
            (childFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment).navController

        binding.bottomNavigationView.setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        // Set up the toolbar with the navigation controller and configuration
        binding.toolbar3.setupWithNavController(navController, appBarConfiguration)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.historyFragment || destination.id == R.id.profileFragment) {
                (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
                binding.toolbar3.navigationIcon = null
            } else {
                (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }

            if (destination.id == R.id.homeFragment) {
                binding.toolbar3.inflateMenu(R.menu.home_menu)
                binding.toolbar3.setOnMenuItemClickListener { menuItem ->
                    if (menuItem.itemId == R.id.actionButtonLogout) {
                        lifecycleScope.launch {
                           viewModel.logout()
                            findNavController().popBackStack()
                            requireActivity().finish()
                        }
                        true
                    } else {
                        false
                    }
                }
            } else {
                // Remove the logout button from the toolbar for other fragments
                binding.toolbar3.menu.clear()
            }
        }
    }
}
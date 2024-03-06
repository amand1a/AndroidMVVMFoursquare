package com.example.foursquare.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foursquare.R
import com.example.foursquare.databinding.HomeFragmentBinding
import com.example.foursquare.domain.model.Card

import com.example.foursquare.presentation.adapter.CardAdapter
import com.example.foursquare.presentation.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUser()
    }

    lateinit var binding: HomeFragmentBinding
    lateinit var adapter: CardAdapter
    private val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomeFragmentBinding.bind(view)
        init()
       initObserver()
    }

    fun init() {

        adapter = CardAdapter { findNavController().navigate(R.id.action_homeFragment_to_itemFragment2 , bundleOf("id" to it.id))
        viewModel.saveUser(it)}
        binding.apply {
            RecyclerViewHome.adapter = adapter
            RecyclerViewHome.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , true )

        }
    }


    fun initObserver(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.cardList.collect{
                it?.let {
                    updateUi(it)
                }
            }
        }
    }

    fun updateUi(array: ArrayList<Card>){
        adapter.addElem(array)

    }

}
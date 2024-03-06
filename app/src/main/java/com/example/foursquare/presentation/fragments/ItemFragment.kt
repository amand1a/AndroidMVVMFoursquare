package com.example.foursquare.presentation.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.foursquare.R
import com.example.foursquare.databinding.ItemFragmentBinding
import com.example.foursquare.domain.model.ItemPlace
import com.example.foursquare.presentation.viewModel.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ItemFragment : Fragment(R.layout.item_fragment) {
    lateinit var binding: ItemFragmentBinding

    private val viewModel: ItemViewModel by  viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = this.arguments?.getString("id")
        viewModel.getItemCard(id ?: "0")

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding =  ItemFragmentBinding.bind(view)
        init()
        initObservers()


    }


    fun init(){

    }


    fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.itemCard.collect {
                it?.let {
                    updateUi(it)
                }
            }
        }
    }

     fun updateUi(item : ItemPlace){
         binding.apply {
             textViewBeenHere.text = item.beenHere.toString()
             textViewCategories.text = item.categories
             textViewContact.text  = item.contact
             textViewLocation.text = item.location
             textViewName.text = item.name

             if(item.images.isNotEmpty()) {
                 val imageLoader = ImageLoader(requireContext())
                 val request = ImageRequest.Builder(requireContext())

                     .data(item.images[0])
                     .target(imageView2) // Use the correct ImageView ID here
                     .build()
                 imageView2.scaleType = ImageView.ScaleType.CENTER_CROP
                 CoroutineScope(Dispatchers.Main).launch {
                     imageLoader.enqueue(request)
                 }
             }
         }

     }
}
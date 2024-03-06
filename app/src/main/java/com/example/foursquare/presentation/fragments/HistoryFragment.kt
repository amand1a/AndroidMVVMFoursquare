package com.example.foursquare.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foursquare.R
import com.example.foursquare.databinding.HistoryFragmentBinding
import com.example.foursquare.domain.model.Card
import com.example.foursquare.presentation.adapter.CardAdapter
import com.example.foursquare.presentation.viewModel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HistoryFragment: Fragment(R.layout.history_fragment) {

    lateinit var binding: HistoryFragmentBinding
    lateinit var adapter: CardAdapter
    private val viewModel: HistoryViewModel by viewModels ()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCardList()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HistoryFragmentBinding.bind(view)
        init()
        initObserver()
    }

    fun init() {

        adapter = CardAdapter { findNavController().navigate(R.id.action_historyFragment_to_itemFragment22 , bundleOf("id" to it.id)) }
        binding.apply {
            recyclerViewHistory.adapter = adapter
            recyclerViewHistory.layoutManager = LinearLayoutManager(context , LinearLayoutManager.VERTICAL , true )

        }

    }


    fun initObserver(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.historyCards.collect{
                it?.let{
                    updateUi(it)
                }
            }
        }
    }

    fun updateUi(cardList: List<Card>){
        adapter.addElem( ArrayList(cardList))
    }


}

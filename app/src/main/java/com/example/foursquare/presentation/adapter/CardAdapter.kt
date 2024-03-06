package com.example.foursquare.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.foursquare.R
import com.example.foursquare.databinding.PlaceCardBinding
import com.example.foursquare.domain.model.Card
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Headers

class CardAdapter(private val action: (id: Card)-> Unit) : RecyclerView.Adapter<CardAdapter.CardHolder>() {

    var arrayPlaces = arrayListOf<Card>()

    class CardHolder(view: View , private val action: (id: Card) -> Unit) : RecyclerView.ViewHolder(view){
        val binding = PlaceCardBinding.bind(view)

        fun bind(item: Card){
            binding.apply {
                    textViewCardNamePlace.text = item.namePlace
                    textViewCardTypePlace.text = item.typePlace
                    cardView.setOnClickListener{
                        action(item)
                    }


                val imageLoader = ImageLoader(itemView.context)
                val request = ImageRequest.Builder(itemView.context)

                    .data(item.imageUrl)
                    .target(imageViewCard) // Use the correct ImageView ID here
                    .build()
                imageViewCard.scaleType = ImageView.ScaleType.CENTER_CROP
                CoroutineScope(Dispatchers.Main).launch {
                    imageLoader.enqueue(request)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.place_card , parent  ,false)
        return CardHolder(view , action)
    }

    override fun getItemCount(): Int {
        return arrayPlaces.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(arrayPlaces[position])
    }


    fun addElem(array: ArrayList<Card>){
        arrayPlaces = array
        notifyDataSetChanged()
    }
}
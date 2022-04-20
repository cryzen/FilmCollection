package com.example.filmcollection.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmcollection.databinding.ListSingleCardBinding
import com.example.filmcollection.models.SinglePosterModel

class SectionListAdapter(
    private val mContext: Context,
    private val itemList: ArrayList<SinglePosterModel>
) : RecyclerView.Adapter<SectionListAdapter.SingleItemViewHolder>() {

    class SingleItemViewHolder(binding: ListSingleCardBinding) : RecyclerView.ViewHolder(binding.root) {
        var tvTitle: TextView = binding.tvTitle
        var itemImage: ImageView = binding.itemImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleItemViewHolder {
        val binding = ListSingleCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SingleItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SingleItemViewHolder, position: Int) {
        val singlePoster: SinglePosterModel = itemList[position]

        holder.tvTitle.text = singlePoster.getTitle()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}
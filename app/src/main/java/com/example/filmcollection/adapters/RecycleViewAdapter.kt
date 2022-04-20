package com.example.filmcollection.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmcollection.databinding.ListItemBinding
import com.example.filmcollection.models.SectionDataModel

class RecyclerViewDataAdapter(
    private val mContext: Context,
    private val dataList: ArrayList<SectionDataModel>
): RecyclerView.Adapter<RecyclerViewDataAdapter.ItemViewHolder>() {

    class ItemViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var itemTitle: TextView = binding.itemTitle
        var recyclerViewList: RecyclerView = binding.recyclerViewList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding= ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val sectionalName = dataList[position].getHeaderTitle()

        val singleSectionItems = dataList[position].getAllItemsInSection()

        holder.itemTitle.text = sectionalName

        val itemListAdapter = SectionListAdapter(mContext, singleSectionItems)

        holder.recyclerViewList.setHasFixedSize(true)
        holder.recyclerViewList.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerViewList.adapter = itemListAdapter
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
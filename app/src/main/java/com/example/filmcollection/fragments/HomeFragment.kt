package com.example.filmcollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmcollection.databinding.FragmentHomeBinding
import com.example.filmcollection.model.RecyclerViewDataAdapter
import com.example.filmcollection.model.SectionDataModel
import com.example.filmcollection.model.SinglePosterModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var adapter: RecyclerView.Adapter<RecyclerViewDataAdapter.ItemViewHolder>? = null
    private lateinit var allSampleData: ArrayList<SectionDataModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allSampleData = ArrayList()

        createDummyData()

        adapter = RecyclerViewDataAdapter(requireContext(), allSampleData)

        binding.recycleView.setHasFixedSize(true)
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recycleView.adapter = adapter
    }

    private fun createDummyData() {
        for (i in 1..5){
            val dm = SectionDataModel()
            dm.setHeaderTitle("Section $i")

            val singleItem: ArrayList<SinglePosterModel> = ArrayList()

            for (j in 0..5){
                singleItem.add(SinglePosterModel("Item $j", "Url $j"))
            }
            dm.setAllItemInSection(singleItem)

            allSampleData.add(dm)
        }
    }
}
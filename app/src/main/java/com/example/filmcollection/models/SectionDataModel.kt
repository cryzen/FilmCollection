package com.example.filmcollection.models

class SectionDataModel {

    private lateinit var headerTitle: String
    private lateinit var allItemInSection: ArrayList<SinglePosterModel>

    fun getHeaderTitle(): String {
        return headerTitle
    }

    fun setHeaderTitle(headerTitle: String?) {
        this.headerTitle = headerTitle!!
    }

    fun getAllItemsInSection(): ArrayList<SinglePosterModel> {
        return allItemInSection
    }

    fun setAllItemInSection(allItemInSection: ArrayList<SinglePosterModel>) {
        this.allItemInSection = allItemInSection
    }
}
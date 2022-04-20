package com.example.filmcollection.models

class SinglePosterModel(title: String?, poster: String?){
    private var title: String = title!!
    private var poster: String = poster!!

    fun getTitle(): String {
        return title
    }

    fun setTitle(name: String?) {
        title = name!!
    }

    fun getPoster(): String {
        return poster
    }

    fun setPoster(poster: String?) {
        this.poster = poster!!
    }
}
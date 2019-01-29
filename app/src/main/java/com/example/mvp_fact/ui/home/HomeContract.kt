package com.example.mvp_fact.ui.home

import okhttp3.Response

interface HomeContract {

    interface View{
        fun showResults(results: List<Response>)
        fun showError(message: String)
    }

    interface Presenter{
        fun getDetails(animalId: String, animalDesc: String, updatedAt: String)
    }
}
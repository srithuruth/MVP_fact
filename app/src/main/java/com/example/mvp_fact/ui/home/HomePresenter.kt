package com.example.mvp_fact.ui.home

import com.example.mvp_fact.model.APIData
import com.example.mvp_fact.model.APIResponse
import com.example.mvp_fact.network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class HomePresenter(
    private val apiService: APIService,
    private val view: HomeContract.View): HomeContract.Presenter {


    override fun getDetails(animalId: String, animalDesc: String, updatedAt: String) {
        apiService.getDetails("cat", 11).enqueue(object : Callback<List<APIData>> {
            override fun onFailure(call: Call<List<APIData>>, t: Throwable) {
                view.showError("Please try again")
            }

            override fun onResponse(call: Call<List<APIData>>, response: Response<List<APIData>>) {
                if (response.isSuccessful) {
                    view.showResults(response.body()?: emptyList())
                } else {
                    view.showError("An unknown  error occured")
                }
            }

        })
    }
}





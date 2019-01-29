package com.example.mvp_fact.network


import com.example.mvp_fact.model.APIData
import com.example.mvp_fact.model.APIResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET(API_ENDPOINT)
    fun getDetails(@Query("animal") animal: String,
                 @Query("amount") amount: Int): Call<List<APIData>>

}
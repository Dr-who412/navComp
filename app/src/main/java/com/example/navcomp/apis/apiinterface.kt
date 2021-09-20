package com.example.navcomp.apis


import com.example.mvvmtask.Data.modeldata
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("beers")
    fun call (): Call<ArrayList<modeldata>>
}
package com.example.demomvpretrofit.Apis

import com.example.demomvpretrofit.Models.PerroModel
import retrofit2.http.GET

interface DogsApi{

    @GET( "api/breed/hound/images")
    fun recuperaListaPorRaza():retrofit2.Call<PerroModel>

}
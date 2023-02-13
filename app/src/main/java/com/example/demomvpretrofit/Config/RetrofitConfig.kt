package com.example.demomvpretrofit.Config

import com.example.demomvpretrofit.Apis.DogsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    val URL_BASE = "https://dog.ceo/"
    fun obtenerConfiguracionRetrofit():DogsApi{

        var mRetrofit= Retrofit.Builder(
        )
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return mRetrofit.create(DogsApi::class.java)
    }

}
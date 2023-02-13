package com.example.demomvpretrofit.Models

import com.google.gson.annotations.SerializedName

data class PerroModel (
    @SerializedName("message") var listaPerros  :ArrayList<String>,
    @SerializedName("status")  var status       : String
    )

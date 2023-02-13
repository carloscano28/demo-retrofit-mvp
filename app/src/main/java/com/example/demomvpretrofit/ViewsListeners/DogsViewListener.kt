package com.example.demomvpretrofit.ViewsListeners

interface DogsViewListener {

    fun onGetDogListSucces(lista:ArrayList<String>)
    fun onGetListFail(mensaje: String)

}
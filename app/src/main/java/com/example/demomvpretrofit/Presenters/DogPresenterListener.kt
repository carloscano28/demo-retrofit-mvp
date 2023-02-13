package com.example.demomvpretrofit.Presenters

interface DogPresenterListener {

    fun consumirListaPerros()
    fun consumoExitoso(lista:ArrayList<String>)
    fun consumoFallido(mensaje:String)

}
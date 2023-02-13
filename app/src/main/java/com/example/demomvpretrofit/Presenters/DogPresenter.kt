package com.example.demomvpretrofit.Presenters

import com.example.demomvpretrofit.Dao.WebServices.DocWebService
import com.example.demomvpretrofit.ViewsListeners.DogsViewListener

class DogPresenter(val vista:DogsViewListener):DogPresenterListener {

    val mModel= DocWebService(this)

    override fun consumirListaPerros() {
        mModel.consumirListaPerros()
    }

    override fun consumoExitoso(lista: ArrayList<String>) {
        vista.onGetDogListSucces(lista)
    }

    override fun consumoFallido(mensaje: String) {
        vista.onGetListFail(mensaje)
    }
}
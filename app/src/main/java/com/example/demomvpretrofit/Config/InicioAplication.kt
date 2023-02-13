package com.example.demomvpretrofit.Config

import android.app.Application
import com.example.demomvpretrofit.Apis.DogsApi


class InicioAplication: Application() {

    companion object{
        lateinit var webServicesGlobal:DogsApi

        fun funcionglobal(){
            println("Hola mundo")
        }
    }

    override fun onCreate() {
        super.onCreate()

        //Este objeto ya puede ser accedido en cualquier parte dela app
        webServicesGlobal = RetrofitConfig().obtenerConfiguracionRetrofit()
    }

}
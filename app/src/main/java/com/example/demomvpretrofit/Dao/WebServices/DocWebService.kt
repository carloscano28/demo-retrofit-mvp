package com.example.demomvpretrofit.Dao.WebServices


import com.example.demomvpretrofit.Config.InicioAplication
import com.example.demomvpretrofit.Models.PerroModel
import com.example.demomvpretrofit.Presenters.DogPresenterListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DocWebService(val presentador: DogPresenterListener): DogWebServiceListener {

     override fun consumirListaPerros() {
         val callRespuesta = InicioAplication.webServicesGlobal.recuperaListaPorRaza()
         callRespuesta.enqueue(object : Callback<PerroModel> {

             override fun onResponse(
                 call: Call<PerroModel>,
                 response: Response<PerroModel>
             ) {
                 if(response.isSuccessful){
                     val objetoPerro= response.body()
                     if (objetoPerro!=null){
                         val tamanio = objetoPerro.listaPerros
                         // devolver lista al presenter
                         presentador.consumoExitoso (objetoPerro.listaPerros)
                     }else{
                         presentador.consumoFallido ( "Objeto vacio")
                         // notifivar objeto nulo
                     }
                 }else{
                     presentador.consumoFallido("Respse fail ${response.code()}")
                 }
             }
             override fun onFailure(call: Call<PerroModel>, t: Throwable) {
                presentador.consumoFallido(t.message.toString())
             }
         })
     }

}
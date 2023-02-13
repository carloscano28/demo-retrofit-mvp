package com.example.demomvpretrofit.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demomvpretrofit.R

class PerroAdapter(private var dataSet: ArrayList<String>) :
    RecyclerView.Adapter<PerroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.perro_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val txtUrlPerro1: ImageView
        init {
            txtUrlPerro1= view.findViewById(R.id.txtUrlPerro)
        }

       fun enlazarItem(item:String){
           Glide.with(view.context).load(item).into(txtUrlPerro1)
        }
    }
}

package com.example.vannakimhai.Adpator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vannakimhai.Model.Product
import com.example.vannakimhai.R

import com.facebook.drawee.view.SimpleDraweeView

class AdaptorOrder (val product: Array<Product>) : RecyclerView.Adapter<AdaptorOrder.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent?.context).inflate(R.layout.view_holder_adaptor_order,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = product[position]
        holder.txtDate.text = item.date
        holder.txtStstus.text = item.status
        holder.txtTotal.text = item.total

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtStstus = itemView.findViewById(R.id.status) as TextView
        var txtDate = itemView.findViewById(R.id.date) as TextView
        var txtTotal = itemView.findViewById(R.id.total) as TextView
    }

}

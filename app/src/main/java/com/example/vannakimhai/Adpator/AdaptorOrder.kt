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
        holder.textViewDepartment.text = item.department
        holder.textViewName.text = item.name

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById(R.id.name) as TextView

        val textViewDepartment = itemView.findViewById(R.id.department) as TextView
    }

}

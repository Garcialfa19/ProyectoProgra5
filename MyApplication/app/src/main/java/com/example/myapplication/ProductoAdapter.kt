package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductoAdapter(private val productList: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.tvNomProducto)
        val descripcionTextView: TextView = itemView.findViewById(R.id.tvDescripcion)
        val precioTextView: TextView = itemView.findViewById(R.id.tvPrecio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productList[position]

        holder.nombreTextView.text = producto.nombre
        holder.descripcionTextView.text = producto.descripcion
        holder.precioTextView.text = producto.precioUnitario.toString()
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}

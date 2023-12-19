package com.example.myapplication

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.modelo.Producto
import com.google.gson.Gson


class CarritoAdapter(
    private val context: Context,
    private val listaProductos: MutableList<Producto>,
    private val carroCompras: ArrayList<Producto>
) : RecyclerView.Adapter<CarritoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.tvNomProducto)
        val descripcionTextView: TextView = itemView.findViewById(R.id.tvDescripcion)
        val precioTextView: TextView = itemView.findViewById(R.id.tvPrecio)
        val imagenView: ImageView = itemView.findViewById(R.id.imageView2)
        val cbCarro: CheckBox = itemView.findViewById(R.id.cbCarro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.cart_view, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = listaProductos[position]

        holder.nombreTextView.text = producto.nombre
        holder.descripcionTextView.text = producto.descripcion
        holder.precioTextView.text = producto.precioUnitario.toString()
        // Aquí utilizamos el método contains para verificar si el producto está en el carro
        holder.cbCarro.isChecked = carroCompras.contains(producto)

        holder.cbCarro.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                carroCompras.add(producto)
            } else {
                carroCompras.remove(producto)
            }
            guardarSharedPreferences()
        }
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    private fun guardarSharedPreferences() {
        val sp: SharedPreferences = context.getSharedPreferences("carro_compras", MODE_PRIVATE)
        val editor = sp.edit()

        // Utilizamos apply() en lugar de clear().apply() para no borrar todas las preferencias
        editor.putString("productos", Gson().toJson(carroCompras))
        editor.apply()
    }
}
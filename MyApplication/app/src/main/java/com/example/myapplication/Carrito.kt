package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class Carrito : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var adapter: AdaptadorProducto

    var listaProductos = ArrayList<Producto>()
    var carroCompras = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityCrritoBinding.inflate(layoutInflater)
        setContentView(R.layout.cart_view)

        carroCompras = intent.getSerializableExtra("carro_compras") as ArrayList<Producto>

//        setupRecyclerView()
    }


//    fun setupRecyclerView() {
//        binding.rvListaCarro.layoutManager = LinearLayoutManager(this)
//        adapter = AdaptadorCarrito(binding.tvTotal, carroCompras)
//        binding.rvListaCarro.adapter = adapter
//    }


    fun homeCarrito(view: View) {
        println("Estoy en home")
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }

    fun categoriasCarrito(view: View) {
        println("Estoy en categorias")
        val intent = Intent(this, Categoria::class.java)
        startActivity(intent)
    }

    fun cartCarrito(view: View) {
        println("Estoy en cart")
        //val intent = Intent(this, Carrito::class.java)
        //startActivity(intent)
    }


    fun profileCarrito(view: View) {
        println("Estoy en profile")
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }
}
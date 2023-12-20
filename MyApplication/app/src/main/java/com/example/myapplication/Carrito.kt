package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.modelo.Producto


class Carrito : AppCompatActivity() {
    var listaProductos = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_view)

        val btn: Button = findViewById(R.id.button4)

        btn.setOnClickListener {
            Toast.makeText(this, "Compra exitosa", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }
    }


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

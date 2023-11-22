package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Carrito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_view)
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
package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.modelo.Cliente
import kotlin.math.log

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("Estoy en inicio")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_view)

        val cliente=Cliente()
        val nombre=cliente.getNombre()
        println("Estoy en inicio, este es mi nombre: $nombre")

    }
    fun home(view: View) {
        println("Estoy en home")
        //val intent = Intent(this, HomeView::class.java)
        //startActivity(intent)
    }

    fun categorias(view: View) {
        println("Estoy en categorias")
        val intent = Intent(this, Categoria::class.java)
        startActivity(intent)
    }


    fun cart(view: View) {
        println("Estoy en cart")
        val intent = Intent(this, Carrito::class.java)
        startActivity(intent)
    }


    fun profile(view: View) {
        println("Estoy en profile")
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }

}
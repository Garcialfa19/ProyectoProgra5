package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_view)
    }
    fun homePerfil(view: View) {
        println("Estoy en home")
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }

    fun categoriasPerfil(view: View) {
        println("Estoy en categorias")
        val intent = Intent(this, Categoria::class.java)
        startActivity(intent)
    }


    fun cartPerfil(view: View) {
        println("Estoy en cart")
        val intent = Intent(this, Carrito::class.java)
        startActivity(intent)
    }


    fun profilePerfil(view: View) {
        println("Estoy en profile")
        //val intent = Intent(this, Perfil::class.java)
        //startActivity(intent)
    }

    fun cerrarSesionPerfil(view: View) {
        println("Estoy en login")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
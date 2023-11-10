package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class HomeView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_view)

    }


    // tengo que crear otra clase que lleve a home view
    fun home(view: View) {
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }


    // tengo que crear otra clase que lleve a categorias view
    fun categorias(view: View) {
        val intent = Intent(this, categorias::class.java)
        startActivity(intent)
    }

    // tengo que crear otra clase que lleve a cart view
    fun cart(view: View) {
        val intent = Intent(this, CrearCuenta::class.java)
        startActivity(intent)
    }

    // tengo que crear otra clase que lleve a profile view
    fun profile(view: View) {
        val intent = Intent(this, CrearCuenta::class.java)
        startActivity(intent)
    }
}
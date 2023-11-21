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

    fun home(view: View) {
        val intent = Intent(this, HomeView::class.java)
        startActivity(intent)
    }

    fun categorias(view: View) {
        val intent = Intent(this, Categoria::class.java)
        startActivity(intent)
    }

    //
    fun cart(view: View) {
        val intent = Intent(this, Carrito::class.java)
        startActivity(intent)
    }


    fun profile(view: View) {
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }
}
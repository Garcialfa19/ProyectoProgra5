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

<<<<<<< HEAD

=======
>>>>>>> 419e83204421110b2f0ce5f880255236c53369e1
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

    //
    fun profile(view: View) {
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }
}
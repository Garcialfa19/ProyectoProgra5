package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity



class Categoria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categoriaview)
    }

    fun homeCategoria(view: View) {
        println("Estoy en home")
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }

    fun categoriasCategoria(view: View) {
        println("Estoy en categorias")
        //val intent = Intent(this, Categoria::class.java)
        //startActivity(intent)
    }

    fun categoriaAbarrotes(view: View) {
        println("Estoy en categoria Productos")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Abarrotes"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }

    fun categoriaBebidas(view: View) {
        println("Estoy en categoria Bebidas")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Bebidas"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }


    fun cartCategoria(view: View) {
        println("Estoy en cart")
        val intent = Intent(this, Carrito::class.java)
        startActivity(intent)
    }


    fun profileCategoria(view: View) {
        println("Estoy en profile")
        val intent = Intent(this, Perfil::class.java)
        startActivity(intent)
    }

}
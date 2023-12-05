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

    //Funciones de las categorías
    fun categoriaAbarrotes(view: View) {
        println("Estoy en categoria Abarrotes")
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
    fun categoriaBebes(view: View) {
        println("Estoy en categoria Bebes")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Bebes"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaCarnes(view: View) {
        println("Estoy en categoria Carnes")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Carnes"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaCongelados(view: View) {
        println("Estoy en categoria Congelados")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Congelados"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaPersonal(view: View) {
        println("Estoy en categoria Personal")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Personal"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaFrutas(view: View) {
        println("Estoy en categoria Frutas")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Frutas"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaLacteos(view: View) {
        println("Estoy en categoria Lacteos")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Lacteos"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaLimpieza(view: View) {
        println("Estoy en categoria Limpieza")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Limpieza"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaMascotas(view: View) {
        println("Estoy en categoria Mascotas")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Mascotas"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaPanaderia(view: View) {
        println("Estoy en categoria Panaderia")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Panaderia"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaSnacks(view: View) {
        println("Estoy en categoria Snacks")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Snacks"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }
    fun categoriaHogar(view: View) {
        println("Estoy en categoria Hogar")
        val intent = Intent(this, CategoriaProducto::class.java)
        val categoria = "Hogar"
        intent.putExtra("categoria",categoria)
        startActivity(intent)
    }

    //Funciones de botones
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
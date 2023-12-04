package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.Volley
import com.example.myapplication.modelo.Cliente

class  Perfil : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_view)

        //asocio la clase text view al nombre del componente
            val usuario:TextView=findViewById(R.id.txtUsuario)
            val cupones:TextView=findViewById(R.id.CuponesButton)
        //recibo los extras
            val nombre:String? = getIntent().getStringExtra("nombre")
            val cuponesR:Int = getIntent().getIntExtra("cupones",0)

        //cambio los text view
            usuario.setText(nombre)
            cupones.setText(cuponesR.toString())
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
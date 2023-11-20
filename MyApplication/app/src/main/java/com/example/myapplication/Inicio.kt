package com.example.myapplication


import android.os.Bundle
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

}
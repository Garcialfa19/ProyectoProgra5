package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun iniciarSecion(view: View){
        val intent=Intent(this,Inicio::class.java).apply { }
        startActivity(intent)
    }
    fun crearCuenta(view: View){
        val intent= Intent(this,CrearCuenta::class.java).apply { }
        startActivity(intent)
    }


}
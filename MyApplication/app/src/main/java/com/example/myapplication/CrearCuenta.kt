package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class CrearCuenta : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_view)
    }
    fun crearCuenta(view: View){
        val intent= Intent(this,MainActivity::class.java).apply { }
        startActivity(intent)
    }
}
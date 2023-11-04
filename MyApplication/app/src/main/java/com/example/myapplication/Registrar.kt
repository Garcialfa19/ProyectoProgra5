package com.example.myapplication

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.sql.SQLException
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Registrar : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val btnConnect: Button = findViewById(R.id.btnRegistro)
        val btnConnect = R.id.btnRegistro

       // btnConnect.setOnClickListener {
       //     // Ejecutar la tarea de conexión en un hilo separado
        //    ConnectToDatabaseTask().execute()
        }
    }
    fun registrar(view: View){
       // val intent= Intent(this,MainActivity::class.java).apply { }
        //startActivity(intent)
    }



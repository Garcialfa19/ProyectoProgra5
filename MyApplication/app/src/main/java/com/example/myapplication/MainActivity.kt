package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btnInicio)

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val correo: EditText = findViewById(R.id.textCorreo)
                val contrasena: EditText = findViewById(R.id.textContra)

                val correo1:String = correo.getText().toString()
                val contrasena1:String = contrasena.getText().toString()

                println("Correo: $correo1")
                println("Contrasena: $contrasena1")

            }
        })
    }

    fun iniciarSecion(view: View) {
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }

    fun crearCuenta(view: View) {
        val intent = Intent(this, CrearCuenta::class.java)
        startActivity(intent)
    }
}

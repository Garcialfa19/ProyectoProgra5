package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Estoy en mainActivity")

        /* val btn: Button = findViewById(R.id.btn_inicio_log_in_view)

         btn.setOnClickListener(object : View.OnClickListener {
             override fun onClick(v: View?) {
                 val correo: EditText = findViewById(R.id.texto_Correo_log_in_view)
                 val contrasena: EditText = findViewById(R.id.texto_contra_log_in_view)

        val btn: Button = findViewById(R.id.btn_inicio_log_in_view)

        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val correo: EditText = findViewById(R.id.texto_Correo_log_in_view)
                val contrasena: EditText = findViewById(R.id.texto_contra_log_in_view)


                 val correo1:String = correo.getText().toString()
                 val contrasena1:String = contrasena.getText().toString()

                 println("Correo: $correo1")
                 println("Contrasena: $contrasena1")

             }
         })*/
    }

    fun iniciarSecion(view: View) {
        println("Estoy en mainActivity")
        val correo: EditText = findViewById(R.id.texto_Correo_log_in_view)
        val contrasena: EditText = findViewById(R.id.texto_contra_log_in_view)


        val correo1:String = correo.getText().toString()
        val contrasena1:String = contrasena.getText().toString()


        // Imprimir en la consola utilizando Log
        Log.d("MainActivity", "Correo: $correo1, Contraseña: $contrasena1")

        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
        println("Estoy en mainActivity final")

    }

    fun crearCuenta(view: View) {
        val intent = Intent(this, CrearCuenta::class.java)
        startActivity(intent)
    }
}

package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.servicio.ServicioCliente

public class MainActivity : AppCompatActivity() {

    private lateinit var correo: EditText
    private lateinit var contrasena: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Estoy en com.example.myapplication.MainActivity")

        // Initialize views
        correo = findViewById(R.id.texto_Correo_log_in_view)
        contrasena = findViewById(R.id.texto_contra_log_in_view)

        val btn: Button = findViewById(R.id.btn_inicio_log_in_view)

        btn.setOnClickListener {
            validarCredenciales()
        }
    }

    @SuppressLint("LongLogTag")
    private fun validarCredenciales() {
        val correoStr: String = correo.text.toString()
        val contrasenaStr: String = contrasena.text.toString()

        println("Correo: $correoStr")
        println("Contraseña: $contrasenaStr")

        var con=ServicioCliente.ConexionBD

        // For now, I'll just print a message indicating a successful login.
        if (con.validar(correoStr, contrasenaStr)) {
            Log.d("com.example.myapplication.MainActivity", "Login successful")
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
            println("Estoy en com.example.myapplication.MainActivity final")
        } else {
            // Display an error message or handle unsuccessful login
            Log.d("com.example.myapplication.MainActivity", "Login failed")
        }
    }

    fun crearCuenta(view: View) {
        val intent = Intent(this, CrearCuenta::class.java)
        startActivity(intent)
    }
}

package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.servicio.ServicioCliente

class CrearCuenta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_view)
        println("estoy en aqui")
    }

    fun registrar(view: View) {
        println("estoy en metodo registrar")

        // Initialize UI elements
        val nombre: EditText = findViewById(R.id.textNombreR)
        val correo: EditText = findViewById(R.id.textCorreoR)
        val contrasena: EditText = findViewById(R.id.textContrasenaR)
        val telefono: EditText = findViewById(R.id.textTelR)

        // Get values from UI elements
        val nombre1: String = nombre.text.toString()
        val correo1: String = correo.text.toString()
        val contrasena1: String = contrasena.text.toString()

        // Handle potential conversion error for telefono
        val telefonoText: String = telefono.text.toString()
        val telefono1: Int = if (telefonoText.isNotEmpty()) telefonoText.toInt() else 0

        // Imprimir en la consola utilizando Log
        Log.d("Registrar", "Nombre: $nombre1, Correo: $correo1, Contraseña: $contrasena1, Telefono: $telefono1 ")

        //llega hasta aca
        var conexion = ServicioCliente.ConexionBD
        println("inicio conexion")

        //val agregar=ConexionCliente.ConexionBD.agregarUsuario(conexion,nombre1,correo1,contrasena1, 1,telefono1)
        val agregar = ServicioCliente.ConexionBD.agregarUsuario(nombre1, correo1, contrasena1, 1, telefono1)
        println("final conexion")

        // Continue with the rest of your code, e.g., handle the result of agregar

        // Example: Navigate to MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

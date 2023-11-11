/*package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.servicio.Conexion
import com.example.myapplication.modelo.Cliente
import com.example.myapplication.servicio.ServicioCliente


class Registrar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_view)
    }

    fun registrar(view: View) {
        // Get references to EditText fields
        val nombre: EditText = findViewById(R.id.textNombreR)
        val correo: EditText = findViewById(R.id.textCorreoR)
        val contrasena: EditText = findViewById(R.id.textContrasenaR)
        val telefono: EditText = findViewById(R.id.textTelR)

        // Get values from EditText fields
        val nombre1: String = nombre.text.toString()
        val correo1: String = correo.text.toString()
        val contrasena1: String = contrasena.text.toString()
        val telefono1: Int = telefono.text.toString().toInt()

        // Log the values
        Log.d("Registrar", "Nombre: $nombre1, Correo: $correo1, Contraseña: $contrasena1, Telefono: $telefono1")

        // Uncomment the following lines after implementing ConexionBD and agregarUsuario
        val conexion = Conexion.ConexionBD.connectToDatabase()
        val agregar = ServicioCliente.ConexionBD.agregarUsuario(conexion, nombre1, correo1, contrasena1, 1, telefono1)

        // Assuming you want to navigate back to the MainActivity after registration
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
*/
package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.servicio.ConexionCliente

class CrearCuenta : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_view)
        println("estoy en aqui")
    }

    fun registrar(view: View){
        println("estoy en metodo registrar")
        val intent= Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)

        val nombre: EditText = findViewById(R.id.textNombreR)
        val correo: EditText = findViewById(R.id.textCorreoR)
        val contrasena: EditText = findViewById(R.id.textContrasenaR)
        val telefono: EditText = findViewById(R.id.textTelR)



        val nombre1:String = nombre.getText().toString()
        val correo1:String = correo.getText().toString()
        val contrasena1:String = contrasena.getText().toString()
        val telefono1:Int = telefono.getText().toString().toInt()




        // Imprimir en la consola utilizando Log
        Log.d("Registrar", "Nombre: $nombre1,Correo: $correo1, Contraseña: $contrasena1,Telefono:$telefono1 ")
        //llega hasta aca
        var conexion= ConexionCliente.ConexionBD.connectToDatabase()
        println("inicio conexion")
        //val agregar=ConexionCliente.ConexionBD.agregarUsuario(conexion,nombre1,correo1,contrasena1, 1,telefono1)
        val agregar=ConexionCliente.ConexionBD.agregarUsuario(conexion,nombre1,correo1,contrasena1, 1,telefono1)
        println("final conexion")
    }


}
/*
fun main() {
    // Imprimir en la consola utilizando Log
    //Log.d("Registrar", "Nombre: $nombre1,Correo: $correo1, Contraseña: $contrasena1,Telefono:$telefono1 ")
    //llega hasta aca
    var conexion= ConexionCliente.ConexionBD.connectToDatabase()
    println("inicio conexion")
    //val agregar=ConexionCliente.ConexionBD.agregarUsuario(conexion,nombre1,correo1,contrasena1, 1,telefono1)
    val agregar=ConexionCliente.ConexionBD.agregarUsuario(conexion,nombre1,correo1,contrasena1, 1,telefono1)
    println("final conexion")
}*/
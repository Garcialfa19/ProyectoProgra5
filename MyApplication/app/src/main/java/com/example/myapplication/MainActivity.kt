package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.servicio.Conexion
import com.example.myapplication.servicio.ConexionCliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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


        var correo1: String = correo.getText().toString()
        val contrasena1: String = contrasena.getText().toString()


        // Imprimir en la consola utilizando Log
        Log.d("MainActivity", "Correo: $correo1, Contraseña: $contrasena1")

        /*try {
            // Utiliza coroutines para realizar operaciones de red en un hilo secundario
            GlobalScope.launch(Dispatchers.IO) {
                // Esto se ejecuta en un hilo secundario
                val conexion = Conexion.ConexionBD.connectToDatabase()
                val usuarioTO = Conexion.ConexionBD.validar(conexion, correo1, contrasena1)

                // Vuelve al hilo principal para actualizar la interfaz de usuario
                withContext(Dispatchers.Main) {
                    // Esto se ejecuta en el hilo principal
                    if (usuarioTO != null) {
                        // Inicio de sesión exitoso
                        val listaUsuarios = Conexion.ConexionBD.getAllUsers(conexion)
                        val intent = Intent(this@MainActivity, Inicio::class.java)
                        startActivity(intent)
                    } else {
                        // Manejar el caso cuando las credenciales no son válidas
                        // Ejemplo de Toast
                        Toast.makeText(
                            this@MainActivity,
                            "Campos inválidos. La clave o correo no son correctos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    correo1 = ""

                }
            }


        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(this@MainActivity, "Error de autenticación", Toast.LENGTH_SHORT).show()
            }
            e.printStackTrace()
        }*/
        val intent = Intent(this@MainActivity, Inicio::class.java)
        startActivity(intent)
        println("Estoy en mainActivity final")

    }


    fun crearCuenta(view: View) {
        val intent = Intent(this, CrearCuenta::class.java)
        startActivity(intent)
    }
}

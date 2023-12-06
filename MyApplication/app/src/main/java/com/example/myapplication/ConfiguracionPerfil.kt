package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ConfiguracionPerfil : AppCompatActivity(){
    var direccion: EditText? = null
    var numTarjeta: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_configuracion)

        direccion = findViewById(R.id.textDireccion)
        numTarjeta = findViewById(R.id.textTarjeta)


        val btn: Button = findViewById(R.id.btnRegistroPerfil)

        btn.setOnClickListener {
            configurar(it)
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
    }
    fun configurar(view: View){
        val ipAddress = "192.168.1.15"  // Cambiar la ip aquií
        val url = "http://$ipAddress/ecomerce/insertar.php"
    }
}
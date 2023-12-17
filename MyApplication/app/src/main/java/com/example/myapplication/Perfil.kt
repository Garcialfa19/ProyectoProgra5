package com.example.myapplication

import NetworkConfig
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Perfil : AppCompatActivity() {
    var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_view)

        //llamo al boton y llamo al listener
        val btn: Button = findViewById(R.id.btnAgregar)
        btn.setOnClickListener {
            registrarMetDir(it)
        }

        //asocio la clase text view al nombre del componente
        val usuario: TextView = findViewById(R.id.txtUsuario)
        val cupones: TextView = findViewById(R.id.CuponesButton)

        //recibo los extras
        id = getIntent().getIntExtra("id", 0)
        val nombre: String? = getIntent().getStringExtra("nombre")
        val cuponesR: Int = getIntent().getIntExtra("cupones", 0)

        //cambio los text view
        usuario.setText(nombre)
        cupones.setText(cuponesR.toString())
    }

    //Funcion de boton configuracion
    fun configuracion(view: View) {
        println("Estoy en configuracion")
        val intent = Intent(this, ConfiguracionPerfil::class.java)
        startActivity(intent)
    }

    //funcion agregar metodo y direccion
    fun registrarMetDir(view: View) {
        //recibo lo que se encuentre en los text view de direccion y metodo de pago
        var direccion: TextView? = findViewById(R.id.textDireccionActual)
        var metodo: TextView? = findViewById(R.id.textMetodoPago)

        val ipAddress =
            NetworkConfig.getBaseUrl() // cambiar la ip en la clase que se llama NetworkConfig
        val url = "http://$ipAddress/ecomerce/insertarMetodoDireccion.php"

        //Log the URL
        Log.d("URL_LOG", "Request URL: $url")

        val queue = Volley.newRequestQueue(this)
        var resultadoPost = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                Toast.makeText(
                    this,
                    "Direccion y metodo insertados exitosamente",
                    Toast.LENGTH_LONG
                ).show()
            }, Response.ErrorListener { error ->
                // Step 6: Log detailed error information
                Log.e("VOLLEY_ERROR", "Error: ${error.networkResponse?.statusCode}", error)
                Toast.makeText(
                    this,
                    "Error ${error.networkResponse?.statusCode}",
                    Toast.LENGTH_LONG
                ).show()
            }) {
            override fun getParams(): MutableMap<String, String>? {
                val parametros = HashMap<String, String>()
                parametros.put("idUsuario", id.toString())
                parametros.put("direccion", direccion?.text.toString())
                parametros.put("metodoDePago", metodo?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)
    }


    //Funcion boton cerrarSesion
    fun cerrarSesionPerfil(view: View) {
        println("Estoy en login")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    //Funciones de botones
    fun homePerfil(view: View) {
        println("Estoy en home")
        val intent = Intent(this, Inicio::class.java)
        startActivity(intent)
    }

    fun categoriasPerfil(view: View) {
        println("Estoy en categorias")
        val intent = Intent(this, Categoria::class.java)
        startActivity(intent)
    }


    fun cartPerfil(view: View) {
        println("Estoy en cart")
        val intent = Intent(this, Carrito::class.java)
        startActivity(intent)
    }


    fun profilePerfil(view: View) {
        println("Estoy en profile")
        //val intent = Intent(this, Perfil::class.java)
        //startActivity(intent)
    }
}
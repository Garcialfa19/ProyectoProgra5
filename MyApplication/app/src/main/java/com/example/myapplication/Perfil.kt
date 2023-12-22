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
import org.json.JSONException
import org.json.JSONObject

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
        val cuponesTxt: TextView = findViewById(R.id.CuponesButton)
        val direccionTxt: TextView = findViewById(R.id.textDireccionActual)
        val metodoTxt: TextView = findViewById(R.id.textMetodoPago)

        //recibo los extras
        id = getIntent().getIntExtra("id", 0)
        val nombreR: String? = getIntent().getStringExtra("nombre")
        val cuponesR: Int = getIntent().getIntExtra("cupones", 0)
        var direccionR: String? = getIntent().getStringExtra("direccion")
        var metodoR: String? = getIntent().getStringExtra("metodoDePago")

        //extraerCliente()

        //Cambio los text view
        usuario.text = nombreR
        cuponesTxt.text=(cuponesR.toString())

        if(direccionR=="")
            direccionTxt.text="Introducir dirección"
        else
            direccionTxt.text = direccionR

        if(metodoR=="")
            metodoTxt.text="Introducir método de pago"
        else
            metodoTxt.text = metodoR
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


    /*
    fun extraerCliente() {

        val ipAddress =
            NetworkConfig.getBaseUrl() // cambiar la ip en la clase que se llama NetworkConfig
        val url = "http://$ipAddress/ecomerce/login.php"

        val queue = Volley.newRequestQueue(this)

        // Log the altered URL
        val alteredUrl = "$url?correo=$correo&contrasena=$contrasena"
        Log.d("URL_LOG", "Altered Request URL: $alteredUrl")



        val stringRequest = StringRequest(
            Request.Method.GET,
            alteredUrl,
            { response ->
                // Log the entire response for debugging
                Log.d("FULL_RESPONSE", response)

                // Parse the JSON response
                try {
                    val jsonResponse = JSONObject(response)
                    val success = jsonResponse.getBoolean("success")

                    if (success) {
                        // Authentication successful

                        // se llama al json respuesta de nombre cliente
                        val clienteJson = jsonResponse?.getJSONObject("cliente")

                        //se extrae la informacion del cliente
                        var nombreR=clienteJson?.getString("nombre")


                        var cuJSON: Any = clienteJson?.get("cupones").toString()
                        var cuponesR = if (cuJSON == "null")
                            0
                        else
                            clienteJson?.getInt("cupones")

                        var diJSON: Any = clienteJson?.get("direccion").toString()
                        direccion = if (diJSON == "null")
                            ""
                        else
                            clienteJson?.getString("direccion")

                        var mpJSON: Any = clienteJson?.get("metodoDePago").toString()
                        metodo = if (mpJSON == "null")
                            ""
                        else
                            clienteJson?.getString("metodoDePago")


                    } else {
                        // Authentication failed
                        val message = jsonResponse.getString("message")
                        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                    }
                } catch (e: JSONException) {
                    // Handle JSON parsing error
                    Log.e("JSON_ERROR", "Error parsing JSON", e)
                    Toast.makeText(this, "Error parsing JSON", Toast.LENGTH_LONG).show()
                }
            },
            { error ->
                // Handle error
                Log.e("VOLLEY_ERROR", "Error: ${error.networkResponse?.statusCode}", error)
                Toast.makeText(
                    this,
                    "Error ${error.networkResponse?.statusCode}",
                    Toast.LENGTH_LONG
                ).show()
            })

        queue.add(stringRequest)
    }*/
}
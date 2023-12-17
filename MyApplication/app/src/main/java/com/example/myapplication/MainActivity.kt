package com.example.myapplication

import NetworkConfig
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    var correo: EditText? = null
    var contrasena: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize textfields
        correo = findViewById(R.id.texto_Correo_log_in_view)
        contrasena = findViewById(R.id.texto_contra_log_in_view)
        // Initialize button
        val btn: Button = findViewById(R.id.btn_inicio_log_in_view)
    }

    fun crearCuenta(view: View) {
        val intent = Intent(this, CrearCuenta::class.java)
        startActivity(intent)
    }

    fun login(view: View) {

        val ipAddress =
            NetworkConfig.getBaseUrl() // cambiar la ip en la clase que se llama NetworkConfig
        val url = "http://$ipAddress/ecomerce/login.php"

        val queue = Volley.newRequestQueue(this)

        val correoText = correo?.text.toString()
        val contrasenaText = contrasena?.text.toString()

        // Log the altered URL
        val alteredUrl = "$url?correo=$correoText&contrasena=$contrasenaText"
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
                        Toast.makeText(this, "Usuario reconocido", Toast.LENGTH_LONG).show()

                        // Extract client data if needed
                        val clienteJson = jsonResponse?.getJSONObject("cliente")

                        // You can use the client data as needed
                        val id = clienteJson?.getInt("idUsuario")
                        val nombre = clienteJson?.getString("nombre")
                        val correo = clienteJson?.getString("correo")
                        val contrasena = clienteJson?.getString("contrasena")

                        var categoria: String? = ""
                        var caJSON: Any = clienteJson?.get("categoria").toString()
                        if (caJSON == "null")
                            categoria = ""
                        else
                            categoria = clienteJson?.getString("categoria")

                        var montoAcumulado: Float? = 0.0f
                        var maJSON: Any = clienteJson?.get("montoAcumulado").toString()
                        if (maJSON == "null")
                            montoAcumulado = 0.0f
                        else
                            montoAcumulado = clienteJson?.getDouble("montoAcumulado")?.toFloat()

                        var direccion: String? = ""
                        var diJSON: Any = clienteJson?.get("direccion").toString()
                        if (diJSON == "null")
                            direccion = ""
                        else
                            direccion = clienteJson?.getString("direccion")

                        var metodoDePago: String? = ""
                        var mpJSON: Any = clienteJson?.get("metodoDePago").toString()
                        if (mpJSON == "null")
                            metodoDePago = ""
                        else
                            metodoDePago = clienteJson?.getString("metodoDePago")

                        var tipo: Int? = 0
                        var tiJSON: Any = clienteJson?.get("tipo").toString()
                        if (tiJSON == "null")
                            tipo = 0
                        else
                            tipo = clienteJson?.getInt("tipo")

                        var cupones: Int? = 0
                        var cuJSON: Any = clienteJson?.get("cupones").toString()
                        if (tiJSON == "null")
                            cupones = 0
                        else
                            cupones = clienteJson?.getInt("cupones")

                        var carritoCompras_idCarrito: Int? = 0
                        var cacoJSON: Any = clienteJson?.get("carrito").toString()
                        if (cacoJSON == "null")
                            carritoCompras_idCarrito = 0
                        else
                            carritoCompras_idCarrito = clienteJson?.getInt("carrito")

                        val telefono: Int? = clienteJson?.getInt("telefono")


                        // Start the new activity
                        val intent = Intent(this, Inicio::class.java)

                        //poner todos los extra para pasarlos a inicio
                        intent.putExtra("id", id)
                        intent.putExtra("nombre", nombre)
                        intent.putExtra("correo", correo)
                        intent.putExtra("contrasena", contrasena)
                        intent.putExtra("categoria", categoria)
                        intent.putExtra("montoAcumulado", montoAcumulado)
                        intent.putExtra("direccion", direccion)
                        intent.putExtra("metodoDePago", metodoDePago)
                        intent.putExtra("tipo", tipo)
                        intent.putExtra("cupones", cupones)
                        intent.putExtra("carritoCompras_idCarrito", carritoCompras_idCarrito)
                        intent.putExtra("telefono", telefono)

                        startActivity(intent)

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
    }
}
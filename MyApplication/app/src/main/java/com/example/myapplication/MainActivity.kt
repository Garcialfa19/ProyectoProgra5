package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.modelo.Cliente
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
        val url = "http://192.168.0.105/ecomerce/login.php"

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
                        val clienteJson = jsonResponse.getJSONObject("cliente")

                        // You can use the client data as needed
                        val id=clienteJson.getInt("idUsuario")
                        val nombre=clienteJson.getString("nombre")
                        val correo=clienteJson.getString("correo")
                        val contrasena=clienteJson.getString("contrasena")
                        val categoria=clienteJson.getString("categoria")
                        val montoAcumulado=clienteJson.getDouble("montoAcumulado").toFloat()
                        val direccion=clienteJson.getString("direccion")
                        val metodoDePago=clienteJson.getString("metodoDePago")
                        val tipo=clienteJson.getInt("tipo")
                        val cupones=clienteJson.getInt("cupones")
                        val carrito=clienteJson.getInt("carrito")
                        val telefono=clienteJson.getInt("telefono")
                        val cliente= Cliente(id,nombre,correo,contrasena,categoria,montoAcumulado,direccion,metodoDePago,tipo,cupones,carrito,telefono)

                        // Start the new activity
//                        val intent = Intent(this, Inicio::class.java)
//                        intent.putExtra( "cliente",cliente )
//                        startActivity(intent)
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
                Toast.makeText(this, "Error ${error.networkResponse?.statusCode}", Toast.LENGTH_LONG).show()
            })

        queue.add(stringRequest)
    }
}

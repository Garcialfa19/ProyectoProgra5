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
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class CrearCuenta : AppCompatActivity() {

    var nombre: EditText? = null
    var correo: EditText? = null
    var contrasena: EditText? = null
    var telefono: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_view)

        nombre = findViewById(R.id.textNombreR)
        correo = findViewById(R.id.textCorreoR)
        contrasena = findViewById(R.id.textContrasenaR)
        telefono = findViewById(R.id.textTelR)

        val btn: Button = findViewById(R.id.btnRegistro)

        btn.setOnClickListener {
            registrar(it)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun registrar(view: View) {
        val url = "http://192.168.0.105/ecomerce/insertar.php"

        //Log the URL
        Log.d("URL_LOG", "Request URL: $url")

        val queue = Volley.newRequestQueue(this)
        var resultadoPost = object : StringRequest(Request.Method.POST, url,
            Response.Listener<String> { response ->
                Toast.makeText(this, "Usuario Insertado exitosamente", Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error ->
                // Step 6: Log detailed error information
                Log.e("VOLLEY_ERROR", "Error: ${error.networkResponse?.statusCode}", error)
                Toast.makeText(this, "Error ${error.networkResponse?.statusCode}", Toast.LENGTH_LONG).show()
            }) {
            override fun getParams(): MutableMap<String, String>? {
                val parametros = HashMap<String, String>()
                parametros.put("nombre", nombre?.text.toString())
                parametros.put("correo", correo?.text.toString())
                parametros.put("contrasena", contrasena?.text.toString())
                parametros.put("telefono", telefono?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)
    }
}

package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

data class Producto(
    val idproducto: Int,
    val nombre: String,
    val categoria: String,
    val oferta: Int,
    val descripcion: String,
    val imagen: String,
    val precioUnitario: Int,
    val disponibilidad: Int,
    val patrocinado: Int
)

class CategoriaProducto : AppCompatActivity() {
    private val productList: MutableList<Producto> = mutableListOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.producto_view)

        val recyclerView: RecyclerView = findViewById(R.id.rvListaProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val ipAddress = "192.168.0.103" // Change the IP address here
        val categoria: String? = intent.getStringExtra("categoria")
        val url = "http://$ipAddress/ecomerce/productos.php?categoria=$categoria"
        Log.d("URL_LOG", "Request URL: $url")

        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                try {
                    val jsonResponse = JSONObject(response)
                    val productosArray = jsonResponse.getJSONArray("productos")

                    for (i in 0 until productosArray.length()) {
                        val productoJson = productosArray.getJSONObject(i)

                        val id = productoJson.getInt("idProducto")
                        val nombre = productoJson.getString("nombre")
                        val categoria = productoJson.getString("categoria")
                        val oferta = productoJson.getInt("oferta")
                        val descripcion = productoJson.getString("descripcion")
                        val imagen = productoJson.getString("imagen")
                        val precioUnitario = productoJson.getInt("precioUnitario")
                        val disponibilidad = productoJson.getInt("disponibilidad")
                        val patrocinado = productoJson.getInt("patrocinado")

                        val producto = Producto(
                            id, nombre, categoria, oferta, descripcion, imagen,
                            precioUnitario, disponibilidad, patrocinado
                        )

                        productList.add(producto)
                    }

                    // Log each product
                    for (product in productList) {
                        Log.d("Product", product.toString())
                    }

                    // Set up RecyclerView and Adapter
                    val adapter = ProductoAdapter(productList)
                    recyclerView.adapter = adapter

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { error ->
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

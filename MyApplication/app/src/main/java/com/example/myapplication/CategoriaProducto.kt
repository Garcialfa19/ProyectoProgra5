package com.example.myapplication


import ProductoAdapter
import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myapplication.R
import com.example.myapplication.modelo.Producto
import org.json.JSONException
import org.json.JSONObject


class CategoriaProducto : AppCompatActivity() {
    private val productList: MutableList<Producto> = mutableListOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.producto_view)

        val recyclerView: RecyclerView = findViewById(R.id.rvListaProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val ipAddress = NetworkConfig.getBaseUrl()
        val categoria: String? = intent.getStringExtra("categoria")
        val url = "http://$ipAddress/ecomerce/productos.php?categoria=$categoria"
        Log.d("URL_LOG", "Request URL: $url")

        val queue = Volley.newRequestQueue(this)

        // Show a loading indicator (optional)
        // You can customize this loading indicator according to your UI design
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.show()

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                // Dismiss the loading indicator
                progressDialog.dismiss()
                Log.d("Response", response)
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
                // Dismiss the loading indicator
                progressDialog.dismiss()

                Log.e("VOLLEY_ERROR", "Error: ${error.networkResponse?.statusCode}", error)
                Toast.makeText(
                    this,
                    "Error: ${error.message}",
                    Toast.LENGTH_LONG
                ).show()
            })

        // Add the request to the queue
        queue.add(stringRequest)
    }
}

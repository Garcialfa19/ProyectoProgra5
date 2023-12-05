package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.modelo.Cliente
import kotlin.math.log

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("Estoy en inicio")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_view)

    }

    //Funciones de botones
    fun home(view: View) {
        println("Estoy en home")
        //val intent = Intent(this, HomeView::class.java)
        //startActivity(intent)
    }

    fun categorias(view: View) {
        println("Estoy en categorias")
        val intent = Intent(this, Categoria::class.java)
        startActivity(intent)
    }


    fun cart(view: View) {
        println("Estoy en cart")
        val intent = Intent(this, Carrito::class.java)
        startActivity(intent)
    }


    fun profile(view: View) {
        println("Estoy en profile")
        val intent = Intent(this, Perfil::class.java)

        //recibo los extra
            val idR:Int = getIntent().getIntExtra("id",0)
            println("Int recibido en inicio: $idR")
            val nombreR:String? = getIntent().getStringExtra("nombre")
            val correoR:String? = getIntent().getStringExtra("correo")
            val contrasenaR:String? = getIntent().getStringExtra("contrasena")
            val categoriaR:String? = getIntent().getStringExtra("categoria")
            val montoAcumuladoR:Float = getIntent().getFloatExtra("montoAcumulado",0.0f)
            val direccionR:String? = getIntent().getStringExtra("direccion")
            val metodoDePagoR:String? = getIntent().getStringExtra("metodoDePago")
            val tipoR:Int = getIntent().getIntExtra("tipo",0)
            val cuponesR:Int? = getIntent().getIntExtra("cupones",0)
            val carritoCompras_idCarritoR:Int = getIntent().getIntExtra("carritoCompras_idCarrito",0)
            val telefonoR:Int = getIntent().getIntExtra("telefono",0)

        //reenvio los extra a perfil
            intent.putExtra("id",idR)
            intent.putExtra("nombre",nombreR)
            intent.putExtra("correo",correoR)
            intent.putExtra("contrasena",contrasenaR)
            intent.putExtra("categoria",categoriaR)
            intent.putExtra("montoAcumulado",montoAcumuladoR)
            intent.putExtra("direccion",direccionR)
            intent.putExtra("metodoDePago",metodoDePagoR)
            intent.putExtra("tipo",tipoR)
            intent.putExtra("cupones",cuponesR)
            intent.putExtra("carritoCompras_idCarrito",carritoCompras_idCarritoR)
            intent.putExtra("telefono",telefonoR)

        startActivity(intent)
    }

}
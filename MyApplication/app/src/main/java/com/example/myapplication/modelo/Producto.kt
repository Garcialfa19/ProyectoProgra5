package com.example.myapplication.modelo

data class Producto(
    val idproducto: Int,
    val nombre: String,
    val categoria: String,
    val oferta: Int,
    val descripcion: String,
    val imagen: String, // This is the image path
    val precioUnitario: Int,
    val disponibilidad: Int,
    val patrocinado: Int
)

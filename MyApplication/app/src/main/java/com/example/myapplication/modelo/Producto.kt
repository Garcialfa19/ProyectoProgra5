package com.example.myapplication.modelo

class Producto(CidProducto:Int, CNombre:String, CCategoria:String, COferta:Boolean, CDescripcion:String, CImagen:String, CprecioUnitario:Float, CDisponibilidad:Boolean, CPatrocinado:Boolean ) {
    var idProducto:Int
    var nombre:String
    var categoria:String
    var oferta:Boolean
    var descripcion:String
    var imagen:String
    var precioUnitario:Float
    var disponibilidad:Boolean
    var patrocinado:Boolean
    init{
        idProducto=CidProducto
        nombre=CNombre
        categoria=CCategoria
        oferta=COferta
        descripcion=CDescripcion
        imagen=CImagen
        precioUnitario=CprecioUnitario
        disponibilidad=CDisponibilidad
        patrocinado=CPatrocinado
    }
}
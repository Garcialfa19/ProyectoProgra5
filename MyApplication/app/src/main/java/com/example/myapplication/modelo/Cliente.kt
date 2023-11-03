package com.example.myapplication.modelo

class Cliente(cIdusuario:Int, Cnombre:String, Capellido:String,Ccorreo:String, Ccontrasena:String, Ccategoria:String,CmontoAcumulado:Float, Cdirecciones:String, CmetodosDePago:String, Ctipo:String, CCupones:Int,CcarritoCompras:Int, CTelefono:Int) {

    var idUsuario:Int
    var nombre:String
    var apellido:String
    var correo:String
    var contrasena:String
    var categoria:String
    var montoAcumulado:Float
    var direcciones:String
    var metodosDePago:String
    var tipo:String
    var cupones:Int
    var carritoCompras: Int
    var telefono:Int

    //combinar las variables de clase con las del constructor
    init{
        idUsuario= cIdusuario
        nombre=Cnombre
        apellido=Capellido
        correo= Ccorreo
        contrasena= Ccontrasena
        categoria= Ccategoria
        montoAcumulado= CmontoAcumulado
        direcciones= Cdirecciones
        metodosDePago= CmetodosDePago
        tipo= Ctipo
        cupones= CCupones
        carritoCompras=CcarritoCompras
        telefono= CTelefono
    }


}
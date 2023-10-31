package com.example.myapplication.modelo

class Cliente(cIdusuario:Int, Ccorreo:String, Ccontrasena:String, CmontoAcumulado:Float, Cdirecciones:String, CmetodosDePago:String, Ctipo:String, CCupones:Int, CTelefono:Int) {

    var idUsuario:Int
    var correo:String
    var contrasena:String
    var montoAcumulado:Float
    var direcciones:String
    var metodosDePago:String
    var tipo:String
    var cupones:Int
    var telefono:Int

    //combinar las variables de clase con las del constructor
    init{
        idUsuario= cIdusuario
        correo= Ccorreo
        contrasena= Ccontrasena
        montoAcumulado= CmontoAcumulado
        direcciones= Cdirecciones
        metodosDePago= CmetodosDePago
        tipo= Ctipo
        cupones= CCupones
        telefono= CTelefono
    }


}
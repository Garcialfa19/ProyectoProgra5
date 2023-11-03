package com.example.myapplication.modelo

class Cliente {
    var idUsuario:Int = 0

    //así se hace un get and set
        //get() {
        //    TODO()
        //}
        //set(value) {}
    var nombre:String
    var correo:String
    var contrasena:String
    var montoAcumulado:Float = 0.0f
    lateinit var direcciones:String
    lateinit var metodosDePago:String
    var tipo:Int
    var cupones:Int = 0
    var telefono:Int

    //De todos los datos
    constructor(idUsuario:Int, nombre:String, correo:String,contrasena:String, montoAcumulado:Float, direcciones:String, metodosDePago: String, tipo:Int, cupones:Int, telefono:Int){
        this.idUsuario=idUsuario
        this.nombre=nombre
        this.correo=correo
        this.contrasena=contrasena
        this.montoAcumulado=montoAcumulado
        this.direcciones=direcciones
        this.metodosDePago=metodosDePago
        this.tipo=tipo
        this.cupones=cupones
        this.telefono=telefono
    }
    //Para registrar usuario
    constructor(nombre:String, correo:String,contrasena:String, telefono:Int,tipo:Int){
        this.nombre=nombre
        this.correo=correo
        this.contrasena=contrasena
        this.telefono=telefono
        this.tipo=tipo
    }






}
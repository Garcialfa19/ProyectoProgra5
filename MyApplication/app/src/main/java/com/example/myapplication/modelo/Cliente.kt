package com.example.myapplication.modelo

class Cliente {
    var idUsuario:Int = 0

    //así se hace un get and set
        //get() {
        //    TODO()
        //}
        //set(value) {}
    var nombre:String = ""
    var correo:String = ""
    var contrasena:String = ""
    var categoria:String = ""
    var montoAcumulado:Float = 0.0f
    var direccion:String = ""
    var metodoDePago:String = ""
    var tipo:Int = 0
    var cupones:Int = 0
    var carrito:Int=0
    var telefono:Int = 0

    //De todos los datos
    constructor(idUsuario:Int, nombre:String, correo:String,contrasena:String,categoria:String,montoAcumulado:Float,direccion:String,metodoDePago:String,tipo:Int,cupones:Int,carrito:Int, telefono:Int){
        this.idUsuario=idUsuario
        this.nombre=nombre
        this.correo=correo
        this.contrasena=contrasena
        this.categoria=categoria
        this.montoAcumulado=montoAcumulado
        this.direccion=direccion
        this.metodoDePago=metodoDePago
        this.tipo=tipo
        this.cupones=cupones
        this.carrito=carrito
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

    fun setIdUsuario(idUsuario: Int){
        this.idUsuario= idUsuario
    }
    fun setNombre(nombre: String){
        this.nombre= nombre
    }
    fun setCorreo(correo: String){
        this.correo= correo
    }
    fun setContarsena(contrasena: String){
        this.contrasena= contrasena
    }
    fun setCategoria(categoria: String){
        this.categoria= categoria
    }
    fun setMontoAcumulado(montoAcumulado: Float){
        this.montoAcumulado= montoAcumulado
    }
    fun setDireccion(direccion: String){
        this.direccion= direccion
    }
    fun setMetodoDePago(metodoDePago: String){
        this.metodoDePago= metodoDePago
    }
    fun setTipo(tipo: Int){
        this.tipo= tipo
    }
    fun setCupones(cupones: Int){
        this.cupones= cupones
    }
    fun setCarrito(carrito: Int){
        this.carrito= carrito
    }
    fun setTelefono(telefono: Int){
        this.telefono= telefono
    }

    fun getIdUsuario(): Int{
        return this.idUsuario
    }
    fun getNombre(): String{
        return this.nombre
    }
    fun getCorreo(): String{
        return this.correo
    }
    fun getContrasena(): String{
        return this.contrasena
    }
    fun getCategoria(): String{
        return this.categoria
    }
    fun getMontoAcumulado(): Float{
        return this.montoAcumulado
    }
    fun getDireccion(): String{
        return this.direccion
    }
    fun getMetodoDePago(): String{
        return this.metodoDePago
    }
    fun getTipo(): Int{
        return this.tipo
    }
    fun getCupones(): Int{
        return this.cupones
    }
    fun getCarrito(): Int{
        return this.carrito
    }
    fun getTelefono(): Int{
        return this.telefono
    }

}
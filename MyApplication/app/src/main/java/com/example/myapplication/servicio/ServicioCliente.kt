package com.example.myapplication.servicio
import com.example.myapplication.modelo.Cliente
import java.sql.CallableStatement
import java.sql.Connection
import java.sql.ResultSet


//**************** EN ESTA CLASE PONEMOS TODO LO QUE TENGA QUE VER CON LA TABLA CLIENTE ********************
class ServicioCliente: Conexion() {
    var cliente: Cliente? = null
    fun login(correo:String, contrasena:String):Cliente?{

        val conexion:Connection=conectar()
        val procedureCall: CallableStatement = conexion.prepareCall("{call login(? , ?)}")

        //pasar los parametros recibidos en la funcion al procedimiento
        procedureCall.setString(1, correo)
        procedureCall.setString(2, contrasena)

        //ejecutar el procedimiento login
        val rs:ResultSet=procedureCall.executeQuery()

        //atajamos al cliente que coincida
        if(rs.next()){
            val nombre:String=rs.getString("nombre")
            val correo:String=rs.getString("correo")
            val contrasena:String=rs.getString("contrasena")
            val tipo:Int=rs.getInt("tipo")
            val telefono:Int=rs.getInt("telefono")

            cliente= Cliente(nombre, correo,contrasena,tipo,telefono)
        }
        else{
            cliente = null
        }
        //terminar la conexion
        conexion.close()

        return cliente
    }

    fun registrarCliente(nombre:String, correo:String, contrasena:String, tipo:Int ,telefono:Int){
        val conexion:Connection=conectar()
        val procedureCall: CallableStatement = conexion.prepareCall("{call registrarCliente(? , ? , ? , ? , ?)}")

        //pasar los parametros recibidos en la funcion al procedimiento
        procedureCall.setString(1, nombre)
        procedureCall.setString(2, correo)
        procedureCall.setString(3, contrasena)
        procedureCall.setInt(4, 1)
        procedureCall.setInt(5, telefono)

        //ejecutar el procedimiento
        procedureCall.execute()

        //terminar la conexion
        conexion.close()
    }
}
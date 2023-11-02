package com.example.myapplication

import java.sql.DriverManager
import java.sql.Connection
import java.sql.CallableStatement

class Conexion {
    //conectarse a la BD
    val url = "jdbc:mysql://localhost:3306/eCommerce" //si no funciona, es el nombre de la conexion
    val user = "root"
    val password = "pp4ssw0rd"
    val connection: Connection = DriverManager.getConnection(url,user,password)

    fun insertar(nombre:String, edad:Int ){
        //llamar al procedimiento almacenado
        val procedureCall: CallableStatement = connection.prepareCall("{call nombreProcedimiento(parametros)}")


        //pasarle los atributos recibidos a los parametros del procedimiento
        procedureCall.setString(1, nombre)
        procedureCall.setInt(2, edad)

        //ejecutar el procedimiento almacenado
        procedureCall.execute()

        //finalmente, terminar la conexion
        connection.close()
    }

}
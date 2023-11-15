package com.example.myapplication.servicio

import com.example.myapplication.modelo.Cliente
import java.sql.DriverManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

open class Conexion {
    //**************************************     ESTA CLASE SOLO SE USA PARA ESTABLECER LA CONEXION       ************************************************
    var con:java.sql.Connection=connectToDatabase()

    private fun connectToDatabase(): java.sql.Connection {
        //datos de la BD
        val url =
            "jdbc:mysql://localhost:3306/eComerce" //nombre del esquema (progra5 o e-Commerce)
        val user = "root"
        val password = "pp4ssw0rd" //admin o pp4ssw0rd

        return DriverManager.getConnection(url, user, password)
    }
}

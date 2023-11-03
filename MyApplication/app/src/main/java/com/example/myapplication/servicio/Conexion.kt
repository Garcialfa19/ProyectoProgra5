package com.example.myapplication.servicio

import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException

open class Conexion {
    //datos de la BD
    val url = "jdbc:mysql://localhost:3306/eCommerce" //si no funciona, es el nombre de la conexion
    val user = "root"
    val password = "pp4ssw0rd"

    fun conectar(): Connection {
        return DriverManager.getConnection(url,user,password)

    }
}
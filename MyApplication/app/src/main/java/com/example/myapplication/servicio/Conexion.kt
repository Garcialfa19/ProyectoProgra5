package com.example.myapplication.servicio

import com.example.myapplication.modelo.Cliente
import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException

class Conexion {
    object ConexionBD{
        fun connectToDatabase(): java.sql.Connection{
            //datos de la BD
            val url = "jdbc:mysql://localhost:3306/eComerce" //si no funciona, es el nombre de la conexion //progra5 o e-Commerce
            val user = "root"
            val password = "pp4ssw0rd" //admin o //pp4ssw0rd

            return DriverManager.getConnection(url, user, password)
        }

        fun getAllUsers(connection: java.sql.Connection): ArrayList<Cliente>{
            var sql= "SELECT * FROM cliente"
            return try{
                var statement= connection.createStatement()
                var resultSet= statement.executeQuery(sql)
                var clientes = ArrayList<Cliente>()
                while (resultSet.next()){
                    var idUsuario: Int = resultSet.getInt("idUsuario")
                    var nombre: String = (resultSet.getString("nombre") ?: "")
                    var correo: String = (resultSet.getString("correo") ?: "")
                    var contrasena: String = (resultSet.getString("contrasena") ?: "")
                    var categoria: String = (resultSet.getString("categoria") ?: "")
                    var montoAcumulado: Float = (resultSet.getFloat("montoAcumulado") ?: 0.0f)
                    var direccion: String = resultSet.getString("direcciones")
                    var metodoDePago: String = resultSet.getString("metodosDePago")
                    var tipo: Int = resultSet.getInt("tipo")
                    var cupones: Int = resultSet.getInt("cupones")
                    var carrito: Int = resultSet.getInt("carritoCompras_idCarrito")
                    var telefono: Int = resultSet.getInt("telefono")
                    //hay que convertir los posibles valores nulos a sus valores default
                    var cliente = Cliente(
                        idUsuario,
                        nombre,
                        correo,
                        contrasena,
                        categoria,
                        montoAcumulado,
                        direccion,
                        metodoDePago,
                        tipo,
                        cupones,
                        carrito,
                        telefono
                    )

                    clientes.add(cliente)
                }

                statement.close()
                resultSet.close()
                clientes

            }catch (e: SQLException){
                println("ERROR SQL: $sql")
                println(e.message)
                ArrayList()
            }
        }
    }

}
fun main() {
    var conexion=Conexion.ConexionBD.connectToDatabase()
    var listaClientes=Conexion.ConexionBD.getAllUsers(conexion)

    listaClientes.forEach { cliente -> println(cliente.getNombre())  }

}
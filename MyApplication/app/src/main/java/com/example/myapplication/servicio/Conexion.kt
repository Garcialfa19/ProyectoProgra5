package com.example.myapplication.servicio

import com.example.myapplication.modelo.Cliente
import java.sql.DriverManager
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

class Conexion {
    object ConexionBD {
        fun connectToDatabase(): java.sql.Connection {
            //datos de la BD
            val url =
                "jdbc:mysql://localhost:3306/eComerce" //si no funciona, es el nombre de la conexion //progra5 o eComerce
            val user = "root"
            val password = "pp4ssw0rd" //admin o //pp4ssw0rd

            return DriverManager.getConnection(url, user, password)
        }

        fun getAllUsers(connection: java.sql.Connection): ArrayList<Cliente> {
            var sql = "SELECT * FROM cliente"
            return try {
                var statement = connection.createStatement()
                var resultSet = statement.executeQuery(sql)
                var clientes = ArrayList<Cliente>()
                while (resultSet.next()) {
                    var idUsuario: Int = resultSet.getInt("idUsuario")
                    var nombre: String = (resultSet.getString("nombre") ?: "")
                    var correo: String = (resultSet.getString("correo") ?: "")
                    var contrasena: String = (resultSet.getString("contrasena") ?: "")
                    var categoria: String = (resultSet.getString("categoria") ?: "")
                    var montoAcumulado: Float = (resultSet.getFloat("montoAcumulado") ?: 0.0f)
                    var direccion: String = resultSet.getString("direccion") ?: ""
                    var metodoDePago: String = resultSet.getString("metodoDePago") ?: ""
                    var tipo: Int = resultSet.getInt("tipo") ?: 0
                    var cupones: Int = resultSet.getInt("cupones") ?: 0
                    var carrito: Int = resultSet.getInt("carritoCompras_idCarrito") ?: 0
                    var telefono: Int = resultSet.getInt("telefono") ?: 0
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

            } catch (e: SQLException) {
                println("ERROR SQL: $sql")
                println(e.message)
                ArrayList()
            }
        }

        fun validar(conexion: java.sql.Connection, correo: String, contrasena: String): Cliente? {
            var sql = "SELECT * FROM cliente where correo=? and contrasena='?'"
            var usuarioTO: Cliente? = null
            var ps: PreparedStatement? = null
            return try {
                ps = conexion.prepareStatement(sql)

                ps.setString(1, correo)
                ps.setString(2, contrasena)

                var statement = conexion.createStatement()
                var resultSet = statement.executeQuery(sql)
                if (resultSet.next()) {
                    var idUsuario: Int = resultSet.getInt("idUsuario")
                    var nombre: String = (resultSet.getString("nombre") ?: "")
                    var correo: String = (resultSet.getString("correo") ?: "")
                    var contrasena: String = (resultSet.getString("contrasena") ?: "")
                    var categoria: String = (resultSet.getString("categoria") ?: "")
                    var montoAcumulado: Float = (resultSet.getFloat("montoAcumulado") ?: 0.0f)
                    var direccion: String = resultSet.getString("direccion") ?: ""
                    var metodoDePago: String = resultSet.getString("metodoDePago") ?: ""
                    var tipo: Int = resultSet.getInt("tipo") ?: 0
                    var cupones: Int = resultSet.getInt("cupones") ?: 0
                    var carrito: Int = resultSet.getInt("carritoCompras_idCarrito") ?: 0
                    var telefono: Int = resultSet.getInt("telefono") ?: 0
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
                    println("usuario reconocido")
                    usuarioTO
                }

                statement.close()
                resultSet.close()
                println("usuario reconocido")
                usuarioTO

            } catch (e: SQLException) {
                println("ERROR SQL: $sql")
                println(e.message)

                null
            }

        }
    }
}
fun main() {
    var conexion=Conexion.ConexionBD.connectToDatabase()
    var listaClientes=Conexion.ConexionBD.validar(conexion, "correo1", "contrasena1")

    val usuarioTO:Cliente =

}

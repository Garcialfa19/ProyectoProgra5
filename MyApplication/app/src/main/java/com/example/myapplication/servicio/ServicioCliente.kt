package com.example.myapplication.servicio
import com.example.myapplication.modelo.Cliente
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException


//**************** EN ESTA CLASE PONEMOS TODO LO QUE TENGA QUE VER CON LA TABLA CLIENTE ********************
open class ServicioCliente {
    object ConexionBD:Conexion() {
        fun getAllUsers(): ArrayList<Cliente> {
            var sql = "SELECT * FROM cliente"
            return try {
                var statement = con.createStatement()
                var resultSet = statement.executeQuery(sql)
                var clientes = ArrayList<Cliente>()
                while (resultSet.next()) {
                    //hay que convertir los posibles valores nulos a sus valores default
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
                    println(nombre)
                    statement.close()
                    resultSet.close()
                }
                statement.close()
                resultSet.close()
                clientes

            } catch (e: SQLException) {
                println("ERROR SQL: $sql")
                println(e.message)
                ArrayList()
            }
            finally {
                con.close()
            }
        }

        fun validar(correo: String, contrasena: String): Boolean {
            var sql = "SELECT * FROM cliente where correo=? and contrasena=?"
            var usuarioTO: Cliente? = null
            var ps: PreparedStatement? = null
            return try {
                ps = con.prepareStatement(sql)

                ps.setString(1, correo)
                ps.setString(2, contrasena)

                var resultSet = ps.executeQuery()
                //si entra en el IF es porque obtuvo un resultado
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
                    resultSet.close()
                    true
                }

                //si no obtuvo resultado, retorna un false
                resultSet.close()
                false

            } catch (e: SQLException) {
                println("ERROR SQL: $sql")
                println(e.message)
                false
            }
            finally {
                con.close()
            }
        }

        fun agregarUsuario(
            nombre: String,
            correo: String,
            contrasena: String,
            tipo: Int,
            telefono: Int
        ): Cliente? {
            var usuarioTO: Cliente? = null
            var ps: PreparedStatement? = null
            val sql = "INSERT INTO cliente (nombre, correo, contrasena, tipo, telefono) VALUES (?, ?, ?, ?, ?)"

            try {
                ps = con.prepareStatement(sql)
                ps.setString(1, nombre)
                ps.setString(2, correo)
                ps.setString(3, contrasena)
                ps.setInt(4, tipo)
                ps.setInt(5, telefono)

                // Execute update se usa para los inserts
                ps.executeUpdate()

                usuarioTO = Cliente(nombre, correo, contrasena, tipo, telefono)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                ps?.close()
            }
            return usuarioTO
        }
    }
}
fun main() {
    var cliente=ServicioCliente.ConexionBD.validar("correo1", "contrasena1")
    var test=ServicioCliente.ConexionBD.getAllUsers()
}


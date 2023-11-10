package com.example.myapplication.servicio
import com.example.myapplication.modelo.Cliente
import java.sql.DriverManager
import java.sql.PreparedStatement


//**************** EN ESTA CLASE PONEMOS TODO LO QUE TENGA QUE VER CON LA TABLA CLIENTE ********************
class ServicioCliente {
   /* object ConexionBD{
        fun connectToDatabase(): java.sql.Connection{
            //datos de la BD
            val url = "jdbc:mysql://localhost:3306/progra5" //si no funciona, es el nombre de la conexion //progra5 o e-Commerce
            val user = "root"
            val password = "admin" //admin o //pp4ssw0rd

            return DriverManager.getConnection(url, user, password)}
   fun agregarUsuario(connection: java.sql.Connection, nombre: String, correo: String, contrasena: String, tipo: Int, telefono:Int): Cliente? {
        var usuarioTO: Cliente? = null
        var ps: PreparedStatement? = null
        val sql = "INSERT INTO cliente (nombre, correo, contrasena, tipo,telefono) VALUES (?, ?, ?, ?, ?);"
        var statement= connection.createStatement()
        var resultSet= statement.executeQuery(sql)


        try {
            ConexionBD
            sql

            ps = connectToDatabase().prepareStatement(sql)
            ps.setString(1, nombre)
            ps.setString(2, correo)
            ps.setString(3, contrasena)
            ps.setInt(4, 1)
            ps.setInt(5, telefono)


            ps.executeUpdate()

            statement.close()
            resultSet.close()

            usuarioTO = Cliente( nombre, correo, contrasena, tipo, telefono)

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            // Paso 5
            println("ERROR SQL: $sql")
            statement.close()
            resultSet.close()

        }
        return usuarioTO
        }

   }
}*/

/* fun agregarUsuario(connection: java.sql.Connection, nombre: String, correo: String, contrasena: String, tipo: Int, telefono:Int): ArrayList<Cliente>{
            var sql= "INSERT INTO cliente (nombre, correo, contrasena, tipo,telefono) VALUES (?, ?, ?, ?, ?);"
            return try{
                var statement= connection.createStatement()
                var resultSet= statement.executeQuery(sql)
                var clientes = ArrayList<Cliente>()
                while (resultSet.next()){
                    resultSet.setString("nombre")
                    var correo: String = (resultSet.getString("correo")
                    var contrasena: String = (resultSet.getString("contrasena")
                    var tipo: Int = resultSet.getInt("tipo")?: 1
                    var telefono: Int = resultSet.getInt("telefono")
                    //hay que convertir los posibles valores nulos a sus valores default
                    var cliente = Cliente(
                        nombre,
                        correo,
                        contrasena,
                        tipo,
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
        }*/

    /*fun registrarCliente(nombre:String, correo:String, contrasena:String, telefono:Int){
        val conexion:Connection=conectar()
        val procedureCall: CallableStatement = conexion.prepareCall("{call Registrar(? , ? , ? , ?)}")

        //pasar los parametros recibidos en la funcion al procedimiento
        procedureCall.setString(1, nombre)
        procedureCall.setString(2, correo)
        procedureCall.setString(3, contrasena)
        procedureCall.setInt(4, telefono)

        //ejecutar el procedimiento
        procedureCall.execute()

        //terminar la conexion
        conexion.close()*/
    }

// package com.example.myapplication
//
// import java.sql.DriverManager
// import java.sql.Connection
// import java.sql.CallableStatement
//
// object Conexion {
// //conectarse a la BD
// val url = "jdbc:mysql://localhost:3306/progra5" //si no funciona, es el nombre de la conexion
// //Naryery: en mi caso es "progra5"
// val user = "root"
// val password = "pp4ssw0rd"
// val connection: Connection = DriverManager.getConnection(url,user,password)
//
// fun getConnection(): Connection {
// return DriverManager.getConnection(url, user, password)
// }
// fun insertar(nombre:String, edad:Int ){
// //llamar al procedimiento almacenado
// val procedureCall: CallableStatement = connection.prepareCall("{call nombreProcedimiento(parametros)}")
//
//
// //pasarle los atributos recibidos a los parametros del procedimiento
// procedureCall.setString(1, nombre)
// procedureCall.setInt(2, edad)
//
// //ejecutar el procedimiento almacenado
// procedureCall.execute()
//
// //finalmente, terminar la conexion
// connection.close()
// }
//
// fun registrar(nombre:String, correo:String, contra:String, tel:Int, tipo:Int){
// println("1!")
// //llamar al procedimiento almacenado
// val procedureCall: CallableStatement = connection.prepareCall("{call Registrar(?,?,?,?,0)}")
//
//
// //pasarle los atributos recibidos a los parametros del procedimiento
// procedureCall.setString(1, nombre)
// procedureCall.setString(2, correo)
// procedureCall.setString(3, contra)
// procedureCall.setInt(4, tel)
// procedureCall.setInt(5, tipo)
// println("2!")
//
// //ejecutar el procedimiento almacenado
// println("3!")
// procedureCall.execute()
// println("4!")
// //finalmente, terminar la conexion
// connection.close()
// println("5!")
// }
// }
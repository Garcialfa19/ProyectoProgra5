package com.example.myapplication.modelo

import java.sql.Time
//HAY QUE AVERIGUAR ESTE TIPO DE DATO "TIME"
class Sucursal(cidSucursal:Int, cdireccion:String, choraApertura:Time, choraCierre:Time) {
    var idSucursal:Int
    var direccion:String
    var horaApertura:Time
    var horaCierre:Time

    init{
        idSucursal=cidSucursal
        direccion=cdireccion
        horaApertura=choraApertura
        horaCierre=choraCierre
    }
}
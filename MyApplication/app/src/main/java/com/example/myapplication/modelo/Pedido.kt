package com.example.myapplication.modelo

import java.util.Date

class Pedido(cidpedido:Int, cfechaPedido: Date, cformaEntrega:String, ctotal:Float, cpagado:Boolean) {
     var idpedido:Int
     var fechaPedido:Date
     var formaEntrega:String
     var total:Float
     var pagado:Boolean
    //ocupamos una lista de productos
    init{
        idpedido=cidpedido
        fechaPedido=cfechaPedido
        formaEntrega=cformaEntrega
        total=ctotal
        pagado=cpagado
    }

}
package com.example.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("Estoy en inicio")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_view)

    }

}
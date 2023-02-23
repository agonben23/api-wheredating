package com.example.models.classes

data class Ciudad(
    val id : Int? = null,
    val nombre: String,
    val tier : Int,
    val latitud : Double,
    val longitud : Double
){}
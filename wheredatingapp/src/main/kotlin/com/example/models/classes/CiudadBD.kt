package com.example.models.classes

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "ciudades")
class CiudadBD(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int? = null,

    @Column(name = "nombre") val nombre: String,
    @Column(name = "importancia") val tier : Int,
    @Column(name = "latitud") val latitud : Double,
    @Column(name = "longitud") val longitud : Double
)
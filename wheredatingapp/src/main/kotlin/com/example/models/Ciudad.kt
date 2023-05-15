package com.example.models

import jakarta.persistence.*


@Entity
@Table(name = "ciudades")
data class Ciudad(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int? = null,

    @Column(name = "población") val nombre: String,
    @Column(name = "provincia") val provincia: String,
    @Column(name = "tier") val tier : Int? = 0,
    @Column(name = "latitud") val latitud : Double,
    @Column(name = "longitud") val longitud : Double
)
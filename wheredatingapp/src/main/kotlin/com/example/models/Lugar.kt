package com.example.models

import jakarta.persistence.*

@Entity
@Table(name = "lugares")
class Lugar (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int? = null,

    @Column(name = "nombre") val nombre: String,

    @OneToOne
    @JoinColumn(name = "ciudad", referencedColumnName = "id")
    val ciudad: Ciudad,

    @Column(name = "uriImagen") val uriImagen: String,
    @Column(name = "descripcion") val descripcion: String,
)
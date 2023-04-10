package com.example.models

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "nick") val nick : String,
    @Column(name = "mail") val mail : String,
    @Column(name = "password") val password: String


    )
package com.example.models

import jakarta.persistence.*

/**
 * Esta es la clase modelo que se usará para almacenar los usuarios en la base de datos
 *
 * La anotación @Table se usa para indicar el nombre de la tabla que se asociará a esta clase
 *
 * @param nick Es el nick del usuario, se usará como clave primaria de la tabla
 * @param mail Es el correo del usuario
 * @param password Es la contraseña del usuario
 * @param token Es el token de autenticación del usuario
 */
@Entity
@Table(name = "usuarios")
class Usuario(
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    */
    @Id
    @Column(name = "nick") val nick : String,
    @Column(name = "mail") val mail : String,
    @Column(name = "password") val password: String,
    @Column(name = "token") val token: String

    )
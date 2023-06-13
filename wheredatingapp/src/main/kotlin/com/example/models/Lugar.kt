package com.example.models

import jakarta.persistence.*

/**
 * Esta es la clase modelo que se usará para almacenar los lugares para visitar en la base de datos
 *
 * La anotación @Table se usa para indicar el nombre de la tabla que se asociará a esta clase
 *
 * @param id Es la id de la tabla, que usa la anotación @GeneratedValue para que se autogenere la clave cuando el objeto se inserte en la base de datos
 * @param nombre Es el nombre del lugar turístico
 * @param ciudad Es la ciudad donde se encuentra el lugar
 * @param uriImagen Es el vínculo a la imagen web del lugar
 * @param descripcion Es una descripción breve del lugar
 */
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
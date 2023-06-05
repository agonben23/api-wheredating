package com.example.models

import jakarta.persistence.*


/**
 * Esta es la clase modelo que se usará para almacenar las ciudades en la base de datos
 *
 * La anotación @Table se usa para indicar el nombre de la tabla que se asociará a esta clase
 *
 * @param id Es la id de la tabla, que usa la anotación @GeneratedValue para que se autogenere la clave cuando el objeto se inserte en la base de datos
 * @param nombre Es el nombre del municipio/población
 * @param provincia Es el nombre de la provincia donde se ubica la población
 * @param tier Es la importancia de la población en la lista de poblaciones.
 * Por ejemplo, el tier 1 indicará que es una ciudad importante mientras que el tier 5 indicará que es un pueblo pequeño
 * @param latitud Es la coordenada de latitud en la que ubica la población, indicada en número decimal
 * @param longitud Es la coordenada de longitud en la que ubica la población, indicada en número decimal
 */
@Entity
@Table(name = "ciudades")
data class Ciudad(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int? = null,

    @Column(name = "nombre") val nombre: String,
    @Column(name = "provincia") val provincia: String,
    @Column(name = "latitud") val latitud : Double,
    @Column(name = "longitud") val longitud : Double,
    @Column(name = "tier") val tier : Int? = 5
)
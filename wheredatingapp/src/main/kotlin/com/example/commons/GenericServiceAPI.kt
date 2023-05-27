package com.example.commons

/**
 * Es la interfaz genérica de las clases de servicio.
 *
 * @property[T] Es la clase modelo que usará la clase de servicio.
 *
 * @property[ID] Es la clase que contiene la ID de la tabla donde se almacenarán los objetos.
 */
interface GenericServiceAPI<T,ID> {

    fun save(entity : T) : T
    fun delete(id : ID)
    operator fun get(id : ID) : T?
    val all : MutableList<T>

}
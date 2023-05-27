package com.example.services

import com.example.commons.GenericServiceImpl
import com.example.models.Ciudad
import com.example.repositories.CiudadesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

/**
 * Es la implementación de la interfaz [CiudadesServiceAPI] para la clase de servicio para la clase modelo [Ciudad]
 *
 * @property ciudadesRepository Es una instancia de la clase servicio [UsuariosRepository]. A través de la anotación @Aurowired se realiza la injección de dependencia de dicha clase.
 */
@Service
class CiudadesService() : CiudadesServiceAPI, GenericServiceImpl<Ciudad,Int>(){

    @Autowired
    lateinit var ciudadesRepository : CiudadesRepository

    override val dao : CrudRepository<Ciudad, Int>
        get() {
            return ciudadesRepository
        }

}
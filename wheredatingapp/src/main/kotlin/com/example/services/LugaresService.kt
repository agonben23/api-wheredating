package com.example.services

import com.example.commons.GenericServiceImpl
import com.example.models.Lugar
import com.example.repositories.LugaresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

/**
 * Es la implementación de la interfaz [LugaresServiceAPI] para la clase de servicio para la clase modelo [Lugar]
 *
 * @property lugaresRepository Es una instancia de la clase servicio [LugaresRepository]. A través de la anotación @Aurowired se realiza la injección de dependencia de dicha clase.
 */
@Service
class LugaresService : LugaresServiceAPI, GenericServiceImpl<Lugar, Int>() {


    @Autowired
    lateinit var lugaresRepository : LugaresRepository

    override val dao : CrudRepository<Lugar, Int>
        get() {
            return lugaresRepository
        }
}
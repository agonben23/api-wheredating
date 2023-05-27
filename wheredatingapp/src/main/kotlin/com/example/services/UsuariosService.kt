package com.example.services

import com.example.commons.GenericServiceImpl
import com.example.models.Ciudad
import com.example.models.Usuario
import com.example.repositories.UsuariosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

/**
 * Es la implementación de la interfaz [UsuariosServiceAPI] para la clase de servicio para la clase modelo [Usuario]
 *
 * @property ciudadesRepository Es una instancia de la clase servicio [UsuariosRepository]. A través de la anotación @Aurowired se realiza la injección de dependencia de dicha clase.
 */
@Service
class UsuariosService : UsuariosServiceAPI, GenericServiceImpl<Usuario, Int>() {

    @Autowired
    lateinit var ciudadesRepository : UsuariosRepository

    override val dao : CrudRepository<Usuario, Int>
        get() {
            return ciudadesRepository
        }

}
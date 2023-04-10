package com.example.services

import com.example.commons.GenericServiceImpl
import com.example.models.Usuario
import com.example.repositories.UsuariosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class UsuariosService : UsuariosServiceAPI, GenericServiceImpl<Usuario, Int>() {

    @Autowired
    lateinit var ciudadesRepository : UsuariosRepository

    override val dao : CrudRepository<Usuario, Int>
        get() {
            return ciudadesRepository
        }

}
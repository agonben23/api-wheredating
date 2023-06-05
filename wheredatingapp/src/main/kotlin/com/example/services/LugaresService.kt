package com.example.services

import com.example.commons.GenericServiceImpl
import com.example.models.Lugar
import com.example.repositories.LugaresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class LugaresService : LugaresServiceAPI, GenericServiceImpl<Lugar, Int>() {


    @Autowired
    lateinit var lugaresRepository : LugaresRepository

    override val dao : CrudRepository<Lugar, Int>
        get() {
            return lugaresRepository
        }
}
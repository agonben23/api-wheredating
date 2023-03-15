package com.example.services

import com.example.commons.GenericServiceImpl
import com.example.models.Ciudad
import com.example.repositories.CiudadesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class CiudadesService() : CiudadesServiceAPI, GenericServiceImpl<Ciudad,Int>(){

    @Autowired
    lateinit var ciudadesRepository : CiudadesRepository

    override val dao : CrudRepository<Ciudad, Int>
        get() {
            return ciudadesRepository
        }

    /*
    fun getByTier(tier : Int): List<Ciudad> {
        val listCiudad = ciudadesRepository
        return listCiudad
    }

    */

}
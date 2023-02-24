package com.example.services

import com.example.models.Ciudad
import com.example.repositories.CiudadesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class CiudadesService(){

    @Autowired
    lateinit var ciudadesRepository : CiudadesRepository

    private val dao : CrudRepository<Ciudad, Int>
        get() {
            return ciudadesRepository
        }

    fun getAll() : List<Ciudad> {
        val listCiudad = dao.findAll()
        val miLista = mutableListOf<Ciudad>()

        listCiudad.forEach {
            ciudad -> miLista.add(ciudad)
        }

        return miLista
    }

    fun insertCiudad(ciudad: Ciudad) : Boolean{

        try {

            dao.save(ciudad)

            return true

        }catch (e : Exception){
            return false
        }

    }

    fun updateCiudad(ciudad: Ciudad) : Boolean{

        try {

            dao.save(ciudad)

            return true

        }catch (e: Exception){
            return false
        }

    }

    /*
    fun getByTier(tier : Int): List<Ciudad> {
        val listCiudad = ciudadesRepository
        return listCiudad
    }

     */

}
package com.example.services

import com.example.models.Ciudad
import com.example.repositories.CiudadesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CiudadesService(){

    @Autowired
    lateinit var ciudadesRepository : CiudadesRepository

    fun getAll() : List<Ciudad> {
        val listCiudad = ciudadesRepository.findAll()
        val miLista = mutableListOf<Ciudad>()

        listCiudad.forEach {
            ciudad -> miLista.add(ciudad)
        }

        return miLista
    }

    fun insertCiudad(ciudad: Ciudad) : Boolean{

        try {

            ciudadesRepository.save(ciudad)

            return true

        }catch (e : Exception){
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
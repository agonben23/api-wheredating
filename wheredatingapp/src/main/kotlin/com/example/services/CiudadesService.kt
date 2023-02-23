package com.example.services

import com.example.models.classes.Ciudad
import com.example.models.classes.CiudadesMapper
import com.example.models.classes.CiudadesRepository

class CiudadesService(private val ciudadesRepository : CiudadesRepository){

    fun getAll() : List<Ciudad> {
        val listCiudad = ciudadesRepository.getAll()
        return listCiudad
    }

}
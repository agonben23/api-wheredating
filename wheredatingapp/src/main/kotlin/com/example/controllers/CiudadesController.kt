package com.example.controllers

import com.example.models.classes.Ciudad
import com.example.models.classes.CiudadesRepository
import com.example.services.CiudadesService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
//TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/productos"
@RequestMapping("/api/v1/ciudades")
@CrossOrigin("*")
class CiudadesController() {

    private val ciudadesService = CiudadesService(CiudadesRepository())

    @GetMapping("/")
    fun getAll() : ResponseEntity<List<Ciudad>> {

        val lisCiudades = ciudadesService.getAll()

        return if (lisCiudades.isNotEmpty()){
            ResponseEntity(lisCiudades, HttpStatus.OK)
        }else{
            ResponseEntity(lisCiudades,HttpStatus.BAD_REQUEST)
        }
    }

}
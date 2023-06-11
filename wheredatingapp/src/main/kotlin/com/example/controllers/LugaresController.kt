package com.example.controllers

import com.example.models.Ciudad
import com.example.models.Lugar
import com.example.services.CiudadesService
import com.example.services.LugaresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/lugares")
@CrossOrigin("*")
class LugaresController {


    @Autowired
    lateinit var lugaresService: LugaresService

    @Autowired
    lateinit var ciudadesService : CiudadesService

    @PostMapping("/bycity")
    fun getbyCity(@RequestBody ciudad : String): ResponseEntity<List<Lugar>> {

        return try {
            val ciudadBusqueda = ciudad.replace("\"","")

            val lisLugares = lugaresService.all.filter { it.ciudad.nombre == ciudadBusqueda }

            ResponseEntity(lisLugares, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(emptyList(), HttpStatus.BAD_REQUEST)
        }

    }

    @PostMapping("/one")
    fun insertLugar(@RequestBody lugar : Lugar) : ResponseEntity<String>{

        return try {
            val insertado = lugaresService.save(lugar)
            ResponseEntity("Lugar insertado correctamente", HttpStatus.OK)
        }catch (e : Exception){
            ResponseEntity("Fallo en la inserción del lugar", HttpStatus.BAD_REQUEST)
        }

    }

}
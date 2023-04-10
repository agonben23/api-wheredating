package com.example.controllers

import com.example.models.Ciudad
import com.example.services.CiudadesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
//TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/productos"
@RequestMapping("/api/v1/ciudades")
@CrossOrigin("*")
class CiudadesController() {

    @Autowired
    lateinit var ciudadesService: CiudadesService

    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<Ciudad>> {

        val lisCiudades = ciudadesService.all

        return if (lisCiudades.isNotEmpty()) {
            ResponseEntity(lisCiudades, HttpStatus.OK)
        } else {
            ResponseEntity(lisCiudades, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/")
    fun insertCiudad(@RequestBody ciudad: Ciudad): ResponseEntity<String> {

        return try {
            val insertado = ciudadesService.save(ciudad)
            ResponseEntity("Ciudad insertada correctamente", HttpStatus.OK)
        }catch (e : Exception){
            ResponseEntity("Fallo en la inserción de la ciudad", HttpStatus.BAD_REQUEST)
        }

    }

    @PostMapping("/all")
    fun insertCiudades(@RequestBody ciudades: List<Ciudad>): ResponseEntity<String> {

        return try {
            for (ciudad in ciudades) {
                val insertado = ciudadesService.save(ciudad)
            }
            ResponseEntity("Ciudades insertadas correctamente", HttpStatus.OK)
        }catch (e : Exception){
            ResponseEntity("Fallo en la inserción de la ciudades", HttpStatus.BAD_REQUEST)
        }

    }

    @PutMapping("/")
    fun updateCiudad(@RequestBody ciudad: Ciudad): ResponseEntity<String> {

        return try {
            val update = ciudadesService.save(ciudad)
            ResponseEntity("Ciudad insertada correctamente", HttpStatus.OK)
        }catch (e : Exception){
            ResponseEntity("Fallo en la actudalización de la ciudad", HttpStatus.BAD_REQUEST)
        }

    }

    /*
    @GetMapping("/?tier={tier}")
    fun getByTier(@PathVariable tier : String) : ResponseEntity<List<Ciudad>>{

        val numTier = tier.toIntOrNull()

        if (numTier != null){
            val lisCiudades = ciudadesService.getByTier(numTier)

            return if (lisCiudades.isNotEmpty()){
                ResponseEntity(lisCiudades, HttpStatus.OK)
            }else{
                ResponseEntity(lisCiudades,HttpStatus.BAD_REQUEST)
            }

        }else{

            return ResponseEntity(null,HttpStatus.BAD_REQUEST)

        }

    }

     */

}
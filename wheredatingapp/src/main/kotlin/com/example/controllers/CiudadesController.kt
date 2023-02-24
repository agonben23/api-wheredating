package com.example.controllers

import com.example.models.Ciudad
import com.example.services.CiudadesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.swing.text.html.parser.Entity


@RestController
//TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/productos"
@RequestMapping("/api/v1/ciudades")
@CrossOrigin("*")
class CiudadesController() {

    @Autowired
    lateinit var ciudadesService: CiudadesService

    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<Ciudad>> {

        val lisCiudades = ciudadesService.getAll()

        return if (lisCiudades.isNotEmpty()) {
            ResponseEntity(lisCiudades, HttpStatus.OK)
        } else {
            ResponseEntity(lisCiudades, HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/")
    fun insertCiudad(@RequestBody ciudad: Ciudad): ResponseEntity<String> {

        val insertado = ciudadesService.insertCiudad(ciudad)

        return if (insertado) {
            ResponseEntity("Ciudad insertada correctamente", HttpStatus.OK)
        } else {
            ResponseEntity("Fallo en la inserción de la ciudad", HttpStatus.BAD_REQUEST)
        }

    }

    @PutMapping("/")
    fun updateCiudad(@RequestBody ciudad: Ciudad): ResponseEntity<String> {

        val update = ciudadesService.updateCiudad(ciudad)

        return if (update) {
            ResponseEntity("Ciudad modificada correctamente", HttpStatus.OK)
        } else {
            ResponseEntity("Fallo en la modifición de la ciudad", HttpStatus.BAD_REQUEST)
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
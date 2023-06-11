package com.example.controllers

import com.example.models.Ciudad
import com.example.services.CiudadesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Esta clase realiza la funciones de controlador para la clase modelo [Ciudad] haciendo uso de la clase servicio [CiudadesService].
 *
 * Acepta las peticiones que se ejecuten a través de la URI relativa "/api/v1/ciudades".
 *
 * @property ciudadesService Es una instancia de la clase servicio [CiudadesService]. A través de la anotación @Aurowired se realiza la injección de dependencia de dicha clase.
 */
@RestController
@RequestMapping("/api/v1/ciudades")
@CrossOrigin("*")
class CiudadesController() {


    @Autowired
    lateinit var ciudadesService: CiudadesService

    /**
     * @return Devuelve todas las ciudades guardadas en la base de datos
     */
    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<Ciudad>> {

        return try {

            val lisCiudades = ciudadesService.all

            ResponseEntity(lisCiudades, HttpStatus.OK)

        }catch (e : Exception){

            ResponseEntity(emptyList(), HttpStatus.BAD_REQUEST)
        }
    }


    /**
     * Inserta una ciudad en la base de datos
     * @param ciudad Es el objeto de la clase [Ciudad] que se introducirá en la base de datos
     * @return Devuelve un string indicando el resultado de la operación
     */
    @PostMapping("/")
    fun insertCiudad(@RequestBody ciudad: Ciudad): ResponseEntity<String> {

        return try {
            val insertado = ciudadesService.save(ciudad)
            ResponseEntity("Ciudad insertada correctamente", HttpStatus.OK)
        }catch (e : Exception){
            ResponseEntity("Fallo en la inserción de la ciudad", HttpStatus.BAD_REQUEST)
        }

    }


    /**
     * Inserta una lista de ciudades en la base de datos
     * @param ciudades Es la lista de objetos de la clase [Ciudad] que se introducirán en la base de datos
     * @return Devuelve un string indicando el resultado de la operación
     */
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

    //Actualiza una ciudad de la base de datos
    /**
     * Actualiza una ciudad en la base de datos
     * @param ciudad Es el objeto de la clase [Ciudad] que se actualizará en la base de datos
     * @return Devuelve un string indicando el resultado de la operación
     */
    @PutMapping("/")
    fun updateCiudad(@RequestBody ciudad: Ciudad): ResponseEntity<String> {

        return try {
            val update = ciudadesService.save(ciudad)
            ResponseEntity("Ciudad actualizada correctamente", HttpStatus.OK)
        }catch (e : Exception){
            ResponseEntity("Fallo en la actualización de la ciudad", HttpStatus.BAD_REQUEST)
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
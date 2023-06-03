package com.example.controllers

import com.example.models.Lugar
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

    @PostMapping("/bycity")
    fun getbyCity(@RequestBody ciudad : String): ResponseEntity<List<Lugar>> {

        var lisLugares = lugaresService.all

        lisLugares = lisLugares.filter { it.ciudad.nombre == ciudad }.toMutableList()

        return if (lisLugares.isNotEmpty()) {
            ResponseEntity(lisLugares, HttpStatus.OK)
        } else {
            ResponseEntity(lisLugares, HttpStatus.BAD_REQUEST)
        }
    }

}
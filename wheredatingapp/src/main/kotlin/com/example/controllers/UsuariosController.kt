package com.example.controllers

import com.example.models.Usuario
import com.example.security.Security
import com.example.services.UsuariosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Esta clase realiza la funciones de controlador para la clase modelo [Usuario] haciendo uso de la clase servicio [UsuariosService].
 *
 * Acepta las peticiones que se ejecuten a través de la URI relativa "/api/v1/usuarios".
 *
 * @property usuariosService Es una instancia de la clase servicio [UsuariosService]. A través de la anotación @Aurowired se realiza la injección de dependencia de dicha clase.
 * @property security Es una instancia de la clase [Security]. A través de la anotación @Aurowired se realiza la injección de dependencia de dicha clase.
 */
@RestController
//TODAS LAS PETICIONES QUE LLEGUEN A "/api/v1/usuarios"
@RequestMapping("/api/v1/usuarios")
@CrossOrigin("*")
class UsuariosController() {

    @Autowired
    lateinit var usuariosService: UsuariosService

    @Autowired
    lateinit var security: Security

    /**
     * Busca un usuario en la base de datos usando los datos del parámetro [usuario]
     * @param usuario Es el objeto de la clase [usuario] que se usará para la búsqueda en la base de datos
     * @return Devuelve el objeto de la base de datos en caso de ser encontrado, en caso contrario devolverá null
     */
    @PostMapping("/one")
    fun getOne(@RequestBody usuario: Usuario): ResponseEntity<Usuario?> {

        //if (security.isAuthorized(token)){
            return try {

                val lisUsers = usuariosService.all

                val response =
                    lisUsers.find { (it.mail == usuario.mail || it.nick == usuario.nick) && it.password == usuario.password }

                ResponseEntity(response, HttpStatus.OK)

            } catch (e: Exception) {
                ResponseEntity(null, HttpStatus.BAD_REQUEST)
            }
        /*
        }else{
            return ResponseEntity(null, HttpStatus.UNAUTHORIZED)
        }

         */

    }


    /**
     * Inserta una ciudad en la base de datos
     * @param usuario Es el objeto de la clase [Usuario] que se introducirá en la base de datos
     * @return Devuelve el objeto de la base de datos en caso de ser insertado correctamente, en caso contrario devolverá null
     */
    @PostMapping("/")
    fun insertUser(@RequestBody usuario: Usuario): ResponseEntity<Usuario?> {

        return try {

            if(!usuariosService.all.any { it.mail == usuario.mail || it.nick == usuario.nick}) {

                val insertado = usuariosService.save(usuario)
                ResponseEntity(usuario, HttpStatus.OK)
            }else{
                ResponseEntity(null,HttpStatus.OK)
            }


        } catch (e: Exception) {
            ResponseEntity(null, HttpStatus.BAD_REQUEST)
        }

    }


}
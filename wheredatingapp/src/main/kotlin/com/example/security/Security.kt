package com.example.security

import com.example.services.UsuariosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller


/**
 * Esta clase se usará para securizar la API REST
 * @property usuariosService Es una instancia de la clase servicio [UsuariosService]. A través de la anotación @Aurowired se realiza la injección de dependencia de dicha clase.
 */

@Controller
class Security {


    @Autowired
    lateinit var usuariosService: UsuariosService

    /**
     * Comprueba si el [token] introducido corresponde a alguno de los usuarios registrados en la base de datos
     * @param token Es el string que contiene el token de autenticación
     * @return `true` si se encuentra en la base de datos, `false` en caso contrario
     */
    fun isAuthorized(token : String) : Boolean{

        return try {

            usuariosService.all.any { it.token == token }

        }catch (exc : Exception){
            false
        }

    }


}
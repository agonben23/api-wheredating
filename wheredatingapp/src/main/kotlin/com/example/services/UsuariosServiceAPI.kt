package com.example.services

import com.example.commons.GenericServiceAPI
import com.example.models.Usuario

/**
 * Es la implementación de la interfaz [GenericServiceAPI] para la clase [Usuario]
 */
interface UsuariosServiceAPI: GenericServiceAPI<Usuario, Int> {
}
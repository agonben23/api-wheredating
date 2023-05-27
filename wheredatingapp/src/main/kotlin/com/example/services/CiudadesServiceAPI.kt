package com.example.services

import com.example.commons.GenericServiceAPI
import com.example.models.Ciudad
import com.example.models.Usuario

/**
 * Es la implementación de la interfaz [GenericServiceAPI] para la clase [Ciudad]
 */
interface CiudadesServiceAPI : GenericServiceAPI<Ciudad, Int> {
}
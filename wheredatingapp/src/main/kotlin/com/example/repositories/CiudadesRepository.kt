package com.example.repositories

import com.example.models.Ciudad
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Es la interfaz que usará el repositorio para la clase [Ciudad]
 */
@Repository
interface CiudadesRepository : CrudRepository<Ciudad,Int> {
}
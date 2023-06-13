package com.example.repositories


import com.example.models.Lugar
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Es la interfaz que usará el repositorio para la clase [Lugar]
 */
@Repository
interface LugaresRepository : CrudRepository<Lugar, Int> {
}
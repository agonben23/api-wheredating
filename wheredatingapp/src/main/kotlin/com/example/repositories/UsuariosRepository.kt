package com.example.repositories

import com.example.models.Ciudad
import com.example.models.Usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * Es la interfaz que usará el repositorio para la clase [Usuario]
 */
@Repository
interface UsuariosRepository: CrudRepository<Usuario, Int> {
}
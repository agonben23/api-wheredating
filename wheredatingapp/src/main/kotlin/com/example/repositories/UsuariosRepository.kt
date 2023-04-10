package com.example.repositories

import com.example.models.Usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuariosRepository: CrudRepository<Usuario, Int> {
}
package com.example.repositories

import com.example.models.Ciudad
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CiudadesRepository : CrudRepository<Ciudad,Int> {
}
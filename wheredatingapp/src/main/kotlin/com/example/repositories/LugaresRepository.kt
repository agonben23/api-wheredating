package com.example.repositories

import com.example.models.Lugar
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface LugaresRepository : CrudRepository<Lugar, Int> {
}
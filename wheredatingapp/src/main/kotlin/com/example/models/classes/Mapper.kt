package com.example.models.classes

interface Mapper<D, E> {

    fun fromEntity(entity : E) : D
    fun toEntity(domain : D) : E

}
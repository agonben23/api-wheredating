package com.example.models.classes

class CiudadesMapper : Mapper<CiudadBD,Ciudad> {
    override fun fromEntity(entity: Ciudad): CiudadBD {
        return CiudadBD(entity.id,entity.nombre,entity.tier,entity.latitud,entity.longitud)
    }

    override fun toEntity(domain: CiudadBD): Ciudad {
        return Ciudad(domain.id,domain.nombre,domain.tier,domain.latitud,domain.longitud)
    }
}
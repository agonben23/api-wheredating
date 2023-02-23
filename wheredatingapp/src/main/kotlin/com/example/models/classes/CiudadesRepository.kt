package com.example.models.classes

import com.example.configuration.SpringJdbcConfig
import org.springframework.jdbc.core.JdbcTemplate


class CiudadesRepository(){
    val dataSource = SpringJdbcConfig().mysqlDataSource()
    val jdbcTemplate = JdbcTemplate(dataSource!!)

    fun getAll() : MutableList<Ciudad>{
        return jdbcTemplate.query("select * from ciudades") { response, _ ->
            Ciudad(nombre = response.getString("nombre"),
                tier = response.getInt("tier"),
                latitud = response.getDouble("latitud"),
                longitud = response.getDouble("longitud"))
        }
    }
}
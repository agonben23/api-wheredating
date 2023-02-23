package com.example.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource


@Configuration
class SpringJdbcConfig {

    @Bean
    fun mysqlDataSource(): DataSource? {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName(
            "com.mysql.jdbc.Driver"
        )
        dataSource.url = "jdbc:mysql://localhost:3306/where-dating"
        dataSource.username = "root"
        dataSource.password = ""
        return dataSource
    }

}
package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Es el 'main' del programa, desde aquí se ejecuta la API REST.
 */
@SpringBootApplication
class WheredatingappApplication

fun main(args: Array<String>) {
	runApplication<WheredatingappApplication>(*args)
}

package com.example.wheredatingapp

import com.example.controllers.*
import com.example.models.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@SpringBootTest
class WheredatingappApplicationTests {

	private val ciudad = Ciudad(nombre="Cádiz", provincia = "Cádiz", latitud = 36.520992, longitud = -6.280312, tier = 2)
	private val usuario = Usuario(nick = "Alex", mail = "algobe2003@gmail.com", password = "alex23", token = "")
	private val lugar = Lugar(nombre = "Puertas de Tierra", ciudad = ciudad, uriImagen = "prueba.jpg", descripcion = "Las Puertas de Tierra es un monumento arquitectónico que supone un reducto de la que fuera muralla de entrada a la ciudad de Cádiz.")

	@Autowired
	lateinit var ciudadesController: CiudadesController

	@Autowired
	lateinit var usuariosController: UsuariosController

	@Autowired
	lateinit var lugaresController: LugaresController

	@Test
	fun contextLoads() {
	}

	@Test
	fun insertCiudadTest(){

		val resultado = ciudadesController.insertCiudad(ciudad)

		assertEquals(HttpStatus.OK,resultado.statusCode,"Ciudad insertada correctamente")

	}

	@Test
	fun insertUsuarioTest(){

		val resultado = usuariosController.insertUser(usuario)

		assertEquals(HttpStatus.OK,resultado.statusCode,"Usuario insertado correctamente")

	}

	@Test
	fun insertLugarTest(){

		val resultado = lugaresController.insertLugar(lugar)

		assertEquals(HttpStatus.OK,resultado.statusCode,"Lugar insertado correctamente")

	}

	@Test
	fun getCiudadesTest(){

		val resultado = ciudadesController.getAll()

		assertNotEquals(null,resultado.body)
		assertNotEquals(0,resultado.body?.size)
	}

	@Test
	fun getOneUserTest(){
		val resultado = usuariosController.getOne(usuario)

		assertNotEquals(null,resultado.body)
	}

	@Test
	fun getLugarByCityTest(){

		val resultado = lugaresController.getbyCity("Cádiz")

		assertNotEquals(0,resultado.body?.size)
	}

}

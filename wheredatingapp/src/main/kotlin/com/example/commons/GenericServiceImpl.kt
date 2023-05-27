package com.example.commons

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.io.Serializable

/**
 * Esta clase es la implementación de la interfaz [GenericServiceAPI]
 */
@Service
abstract class GenericServiceImpl<T : Any,ID : Serializable> : GenericServiceAPI<T, ID> {

    override fun save(entity: T): T {
        return dao.save(entity)
    }

    override fun delete(id: ID) {
        dao.deleteById(id)
    }

    override fun get(id: ID): T? {
        return dao.findByIdOrNull(id)
    }

    override val all: MutableList<T>
        get()  {
            val returnList = mutableListOf<T>()
            dao.findAll().forEach {
                returnList.add(it)
            }
            return returnList
        }

    abstract val dao : CrudRepository<T,ID>
}
package com.example.framework.adapter.mongo.out.persistence.repository

import com.example.framework.adapter.mongo.out.persistence.entity.ProductEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<ProductEntity, Long> {
    fun findProductEntityById(id: Long): ProductEntity

    fun findProductEntities(name: String): List<ProductEntity>
}
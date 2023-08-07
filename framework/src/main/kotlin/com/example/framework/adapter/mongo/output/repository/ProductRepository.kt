package com.example.framework.adapter.mongo.output.repository

import com.example.framework.adapter.mongo.output.entity.ProductEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<ProductEntity, Long> {
    fun findProductEntityById(id: Long): ProductEntity

    fun findProductEntities(name: String): List<ProductEntity>
}
package com.example.framework.adapter.mongo.out.persistence.entity

import com.example.domain.enums.ProductStatus
import com.example.domain.vo.Money
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("product")
data class ProductEntity(
    @Id
    val id: Long,
    val name: String,
    val money: Money,
    val status: ProductStatus
)
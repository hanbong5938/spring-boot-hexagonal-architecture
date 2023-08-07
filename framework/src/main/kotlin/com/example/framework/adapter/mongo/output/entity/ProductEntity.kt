package com.example.framework.adapter.mongo.output.entity

import com.example.domain.entity.Product
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
) {

    fun toDomain() = Product(
        id = id,
        name = name,
        money = money,
        status = status
    )

    companion object {
        fun fromDomain(product: Product) = ProductEntity(
            id = product.id,
            name = product.name,
            money = product.money,
            status = product.status
        )
    }
}
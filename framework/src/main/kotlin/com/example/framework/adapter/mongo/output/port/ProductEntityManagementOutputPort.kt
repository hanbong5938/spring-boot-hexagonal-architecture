package com.example.framework.adapter.mongo.output.port

import com.example.application.ouput.ProductManagementOutputPort
import com.example.domain.entity.Product
import com.example.domain.enums.MoneyCurrency
import com.example.domain.enums.ProductStatus
import com.example.domain.vo.Money
import com.example.framework.adapter.mongo.output.entity.ProductEntity
import com.example.framework.adapter.mongo.output.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductEntityManagementOutputPort(private val productRepository: ProductRepository) :
    ProductManagementOutputPort {
    override fun getProduct(id: Long): Product? {
        return productRepository.findProductEntityById(id).toDomain()
    }

    override fun createProduct(): Product {
        return productRepository.save(
            ProductEntity.fromDomain(
                Product(
                    1,
                    "Product 1",
                    Money(100.0, MoneyCurrency.USD),
                    ProductStatus.ACTIVE
                )
            )
        ).toDomain()
    }
}
package com.example.application.input

import com.example.application.ouput.ProductManagementOutputPort
import com.example.application.usecase.ProductRetrieveUseCase
import com.example.domain.entity.Product
import org.springframework.stereotype.Service

@Service
class ProductRetrieveInputPort constructor(
    private val productManagementOutputPort: ProductManagementOutputPort
): ProductRetrieveUseCase {
    override fun getOrCreateDefault(id: Long): Product {
        return productManagementOutputPort.getProduct(id) ?: productManagementOutputPort.createProduct()
    }
}
package com.example.domain.service

import com.example.domain.entity.Product
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProductCreateServiceTest {

    @Test
    fun createProduct() {
        val product:Product = ProductCreateService.createProduct()

        assertNotNull(product.id)
    }
}
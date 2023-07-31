package com.example.application.ouput

import com.example.domain.entity.Product

interface ProductManagementOutputPort {
    fun getProduct(id: Long): Product?
    fun createProduct(): Product
}
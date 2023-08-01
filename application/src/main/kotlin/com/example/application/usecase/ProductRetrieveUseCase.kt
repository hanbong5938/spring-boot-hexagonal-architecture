package com.example.application.usecase

import com.example.domain.entity.Product

fun interface ProductRetrieveUseCase {
    fun getOrCreateDefault(id: Long): Product
}
package com.example.domain.entity

import com.example.domain.enums.ProductStatus
import com.example.domain.vo.Money

data class Product(
    val id: Long,
    val name: String,
    val money: Money,
    val status: ProductStatus
)

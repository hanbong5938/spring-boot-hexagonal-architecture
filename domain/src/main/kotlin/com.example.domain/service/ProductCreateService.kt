package com.example.domain.service

import com.example.domain.entity.Product
import com.example.domain.enums.MoneyCurrency
import com.example.domain.enums.ProductStatus
import com.example.domain.vo.Money

class ProductCreateService {
    companion object {
        fun createProduct(): Product {
            return Product(
                id = 1,
                name = "Product 1",
                money = Money(
                    amount = 100.0,
                    currency = MoneyCurrency.USD
                ),
                status = ProductStatus.ACTIVE
            )
        }
    }
}
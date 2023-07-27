package com.example.domain.util

import com.example.domain.entity.Product

class ProductUtil {
    companion object {
        fun getInfoString(product: Product): String {
            return "Product(ID=${product.id}, Name=${product.name}, Price=${product.money.amount} ${product.money.currency}, Status=${product.status})"
        }
    }
}
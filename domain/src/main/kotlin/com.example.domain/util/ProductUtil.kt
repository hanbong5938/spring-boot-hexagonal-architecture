package com.example.domain.util

import com.example.domain.entity.Product

class ProductUtil {
    fun getInfoString(product: Product): String {
        return "Product ID: ${product.id}\n" +
                "Name: ${product.name}\n" +
                "Price: ${product.money.amount} ${product.money.currency}\n" +
                "Status: ${product.status}"
    }
}
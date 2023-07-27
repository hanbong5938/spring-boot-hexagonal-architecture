package com.example.domain.aggregate

import com.example.domain.entity.Product

class ProductAggregate(private val products: MutableList<Product>) {
    fun getAllProducts(): List<Product> {
        return products
    }

    fun getProductById(id: Long): Product? {
        return products.find { it.id == id }
    }

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun deleteProduct(product: Product) {
        products.remove(product)
    }

    fun updateProduct(product: Product) {
        val target: Product? = products.find { it.id == product.id }
        if (target != null) {
            products[products.indexOf(target)] = product
        } else {
            throw IllegalArgumentException("Product with ID ${product.id} does not exist.")
        }
    }

    fun getProductCount(): Int {
        return products.size
    }
}

package com.example.domain.aggregate

import com.example.domain.entity.Product

class ProductAggregate(private val products: MutableMap<Long, Product>) {
    fun getAllProducts(): List<Product> {
        return products.values.stream().toList()
    }

    fun getProductById(id: Long): Product? {
        return products[id]
    }

    fun addProduct(product: Product) {
        products.put(product.id, product)
    }

    fun deleteProduct(id: Long) {
        products.remove(id)
    }

    fun updateProduct(product: Product) {
        if (products.containsKey(product.id)) {
            addProduct(product)
        } else {
            throw IllegalArgumentException("Product with ID ${product.id} does not exist.")
        }
    }

    fun getProductCount(): Int {
        return products.size
    }
}

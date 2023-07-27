package com.example.domain.aggregate

import com.example.domain.entity.Product
import com.example.domain.enums.MoneyCurrency
import com.example.domain.enums.ProductStatus
import com.example.domain.vo.Money
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ProductAggregateTest {

    @Test
    fun getAllProducts() {
        val list = mutableListOf(
            Product(1, "Product 1", Money(100.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(2, "Product 2", Money(200.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(3, "Product 3", Money(300.0, MoneyCurrency.JPY), ProductStatus.INACTIVE)
        )

        val productAggregate = ProductAggregate(list)

        val products = productAggregate.getAllProducts()

        assertEquals(list.size, products.size)
    }

    @Test
    fun getProductById() {
        val list = mutableListOf(
            Product(1, "Product 1", Money(100.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(2, "Product 2", Money(200.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(3, "Product 3", Money(300.0, MoneyCurrency.JPY), ProductStatus.INACTIVE)
        )

        val productAggregate = ProductAggregate(list)

        val product = productAggregate.getProductById(1)
        val nullProduct = productAggregate.getProductById(Long.MAX_VALUE)

        assertEquals(list[0], product)
        assertNotEquals(list[1], product)
        assertNull(nullProduct)
    }

    @Test
    fun addProduct() {
        val list = mutableListOf(
            Product(1, "Product 1", Money(100.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(2, "Product 2", Money(200.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(3, "Product 3", Money(300.0, MoneyCurrency.JPY), ProductStatus.INACTIVE)
        )

        val productAggregate = ProductAggregate(list)

        val product = Product(4, "Product 4", Money(400.0, MoneyCurrency.JPY), ProductStatus.ACTIVE)

        productAggregate.addProduct(product)

        assertEquals(list.size, productAggregate.getAllProducts().size)
    }

    @Test
    fun deleteProduct() {
        val product = Product(1, "Product 1", Money(100.0, MoneyCurrency.USD), ProductStatus.ACTIVE)

        val list = mutableListOf(
            product,
            Product(2, "Product 2", Money(200.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(3, "Product 3", Money(300.0, MoneyCurrency.JPY), ProductStatus.INACTIVE)
        )

        val productAggregate = ProductAggregate(list)

        productAggregate.deleteProduct(product)
        productAggregate.deleteProduct(Product(4, "Product 4", Money(400.0, MoneyCurrency.JPY), ProductStatus.ACTIVE))

        assertEquals(list.size, productAggregate.getAllProducts().size)
    }

    @Test
    fun updateProduct() {
        val list = mutableListOf(
            Product(1, "Product 1", Money(100.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(2, "Product 2", Money(200.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(3, "Product 3", Money(300.0, MoneyCurrency.JPY), ProductStatus.INACTIVE)
        )

        val productAggregate = ProductAggregate(list)

        val updatedProduct = Product(1, "Product 1", Money(1000.0, MoneyCurrency.USD), ProductStatus.INACTIVE)
        val empty = Product(4, "Product 4", Money(400.0, MoneyCurrency.JPY), ProductStatus.ACTIVE)

        productAggregate.updateProduct(updatedProduct)

        assertEquals(updatedProduct, productAggregate.getProductById(updatedProduct.id))
        assertThrows(IllegalArgumentException::class.java) {
            productAggregate.updateProduct(empty)
        }
    }

    @Test
    fun getProductCount() {
        val list = mutableListOf(
            Product(1, "Product 1", Money(100.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(2, "Product 2", Money(200.0, MoneyCurrency.USD), ProductStatus.ACTIVE),
            Product(3, "Product 3", Money(300.0, MoneyCurrency.JPY), ProductStatus.INACTIVE)
        )

        val productAggregate = ProductAggregate(list)

        assertEquals(list.size, productAggregate.getProductCount())
    }
}
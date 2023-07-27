package com.example.domain.entity

import com.example.domain.enums.MoneyCurrency
import com.example.domain.enums.ProductStatus
import com.example.domain.vo.Money
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun create() {
        val id = 1L
        val name = "Product 1"
        val money = Money(
            amount = 100.0, currency = MoneyCurrency.USD
        )
        val status = ProductStatus.INACTIVE
        val product = Product(id = id, name = name, money = money, status = status)

        assertEquals(id, product.id)
        assertEquals(name, product.name)
        assertEquals(money, product.money)
        assertEquals(status, product.status)
        assertNotEquals(id + 1, product.id)
        assertNotEquals(name + "1", product.name)
        assertNotEquals(
            Money(
                amount = 100.0, currency = MoneyCurrency.JPY
            ), product.money
        )
        assertNotEquals(ProductStatus.ACTIVE, product.status)
    }
}
package com.example.domain.util

import com.example.domain.entity.Product
import com.example.domain.enums.MoneyCurrency
import com.example.domain.enums.ProductStatus
import com.example.domain.vo.Money
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ProductUtilTest {

    @Test
    fun getInfoString() {
        val id = 1L
        val name = "Product 1"
        val money = Money(
            amount = 100.0, currency = MoneyCurrency.USD
        )
        val status = ProductStatus.ACTIVE
        val product = Product(
            id = id, name = name, money = money, status = status
        )

        val inActiveProduct = Product(
            id = id, name = name, money = money, status = ProductStatus.INACTIVE
        )

        val expected = "Product(ID=$id, Name=$name, Price=${money.amount} ${money.currency}, Status=$status)"

        assertEquals(expected, ProductUtil.getInfoString(product))
        assertNotEquals(expected, ProductUtil.getInfoString(inActiveProduct))
    }
}
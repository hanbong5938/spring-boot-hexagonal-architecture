package com.example.domain.vo

import com.example.domain.enums.MoneyCurrency
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun create() {
        val amount = 100.0
        val currency = MoneyCurrency.USD
        val money = Money(amount = amount, currency = currency)

        assertEquals(amount, money.amount)
        assertEquals(currency, money.currency)
        assertNotEquals(amount + 1, money.amount)
        assertNotEquals(MoneyCurrency.JPY, money.currency)
    }
}
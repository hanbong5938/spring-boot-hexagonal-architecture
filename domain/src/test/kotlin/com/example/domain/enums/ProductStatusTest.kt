package com.example.domain.enums

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ProductStatusTest {

    @Test
    fun values() {
        val values = ProductStatus.values()

        assertEquals(2, values.size)
    }

    @Test
    fun valueOf() {
        val active = ProductStatus.valueOf("ACTIVE")
        val inActive = ProductStatus.valueOf("INACTIVE")

        assertEquals(ProductStatus.ACTIVE, active)
        assertEquals(ProductStatus.INACTIVE, inActive)
        assertNotEquals(ProductStatus.ACTIVE, inActive)
        assertNotEquals(ProductStatus.INACTIVE, active)
    }
}
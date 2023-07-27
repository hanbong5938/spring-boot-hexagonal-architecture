package com.example.domain.constant

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProductConstantsTest {

    @Test
    fun maxNameLength() {
        val maxNameLength = ProductConstants.MAX_PRODUCT_NAME_LENGTH

        assertNotNull(maxNameLength)
    }
}
package com.davidcrespo.shoppingcart

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.math.BigDecimal

class ProductTest {

    @ParameterizedTest(name = "price {0} is rejected")
    @CsvSource(
        "0.00",
        "-0.01",
        "-2.50"
    )
    fun `product rejects non-positive prices`(price: String) {
        assertThrows<IllegalArgumentException> {
            Product(id = "cornflakes", name = "Cornflakes", price = BigDecimal(price))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\t", "\n"])
    fun `product rejects blank identifiers`(id: String) {
        assertThrows<IllegalArgumentException> {
            Product(
                id = id,
                name = "Cornflakes",
                price = BigDecimal("2.50")
            )
        }
    }
}
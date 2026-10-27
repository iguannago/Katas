package com.davidcrespo.shoppingcart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ShoppingCartTest {

    @Test
    fun `adding a product gives it a quantity of one`() {
        val cart = ShoppingCart()
        val cornflakes = Product(
            id = "cornflakes",
            name = "Cornflakes",
            price = BigDecimal("2.50")
        )
        cart.add(cornflakes)

        assertEquals(1, cart.quantityOf(cornflakes.id))
    }

    @Test
    fun `adding the same product twice gives it a quantity of two`() {
        val cart = ShoppingCart()
        val cornflakes = Product(
            id = "cornflakes",
            name = "Cornflakes",
            price = BigDecimal("2.50")
        )
        cart.add(cornflakes)
        cart.add(cornflakes)

        assertEquals(2, cart.quantityOf(cornflakes.id))
    }

}
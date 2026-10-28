package com.davidcrespo.shoppingcart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ShoppingCartTest {

    private val cart = ShoppingCart()

    private val cornflakes = Product(
        id = "cornflakes",
        name = "Cornflakes",
        price = BigDecimal("2.50")
    )

    @Nested
    inner class AddingProducts {

        @Test
        fun `adding a product gives it a quantity of one`() {
            cart.add(cornflakes)

            assertEquals(1, cart.quantityOf(cornflakes.id))
        }

        @Test
        fun `adding the same product twice gives it a quantity of two`() {
            cart.add(cornflakes)
            cart.add(cornflakes)

            assertEquals(2, cart.quantityOf(cornflakes.id))
        }

        @Test
        fun `adding different products tracks their quantities independently`() {
            val bread = Product(
                id = "bread",
                name = "Bread",
                price = BigDecimal("1.20")
            )
            cart.add(cornflakes)
            cart.add(bread)
            cart.add(cornflakes)

            assertEquals(2, cart.quantityOf(cornflakes.id))
            assertEquals(1, cart.quantityOf(bread.id))
        }
    }

    @Nested
    inner class RemovingProducts {
        @Test
        fun `removing a product decreases its quantity by one`() {
            cart.add(cornflakes)
            cart.add(cornflakes)

            cart.remove(cornflakes.id)

            assertEquals(1, cart.quantityOf(cornflakes.id))
        }

        @Test
        fun `removing the last unit leaves a quantity of zero`() {
            cart.add(cornflakes)

            cart.remove(cornflakes.id)

            assertEquals(0, cart.quantityOf(cornflakes.id))
        }

        @Test
        fun `removing an absent product leaves the cart unchanged`() {
            cart.add(cornflakes)

            cart.remove("unknown-product")

            assertEquals(1, cart.quantityOf(cornflakes.id))
            assertEquals(0, cart.quantityOf("unknown-product"))
        }
    }
}
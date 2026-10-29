package com.davidcrespo.shoppingcart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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

    @Nested
    inner class ItemisedReceipt {
        @Test
        fun `an empty cart produces a receipt with no lines and a zero total`() {
            val receipt = cart.receipt()

            assertTrue(receipt.lines.isEmpty())
            assertEquals(0, receipt.total.compareTo(BigDecimal.ZERO))
        }

        @Test
        fun `receipt includes one product and its price as the total`() {
            cart.add(cornflakes)

            val receipt = cart.receipt()

            assertEquals(
                listOf(ReceiptLine(cornflakes, quantity = 1)),
                receipt.lines
            )
            assertEquals(0, receipt.total.compareTo(cornflakes.price))
        }

        @Test
        fun `receipt groups repeated products and totals their prices`() {
            cart.add(cornflakes)
            cart.add(cornflakes)
            cart.add(cornflakes)

            val receipt = cart.receipt()

            assertEquals(
                listOf(ReceiptLine(cornflakes, quantity = 3)),
                receipt.lines
            )
            assertEquals(0, receipt.total.compareTo(BigDecimal("7.50")))
        }

        @Test
        fun `receipt includes different products and sums their prices`() {
            val bread = Product(
                id = "bread",
                name = "Bread",
                price = BigDecimal("1.20")
            )
            cart.add(cornflakes)
            cart.add(cornflakes)
            cart.add(bread)

            val receipt = cart.receipt()

            assertEquals(2, receipt.lines.size)
            assertEquals(
                setOf(
                    ReceiptLine(cornflakes, quantity = 2),
                    ReceiptLine(bread, quantity = 1)
                ),
                receipt.lines.toSet()
            )
            assertEquals(0, receipt.total.compareTo(BigDecimal("6.20")))
        }

        @Test
        fun `adding the same identifier with conflicting details retains the original product`() {
            val updatedCornflakes = cornflakes.copy(
                name = "Updated Cornflakes",
                price = BigDecimal("3.00")
            )
            cart.add(cornflakes)
            cart.add(updatedCornflakes)

            val receipt = cart.receipt()

            assertEquals(
                listOf(ReceiptLine(cornflakes, quantity = 2)),
                receipt.lines
            )
            assertEquals(0, receipt.total.compareTo(BigDecimal("5.00")))
        }

        @Test
        fun `receipt reflects the remaining quantity after removal`() {
            cart.add(cornflakes)
            cart.add(cornflakes)
            cart.remove(cornflakes.id)

            val receipt = cart.receipt()

            assertEquals(
                listOf(ReceiptLine(cornflakes, quantity = 1)),
                receipt.lines
            )
            assertEquals(0, receipt.total.compareTo(BigDecimal("2.50")))
        }
    }

    @Nested
    inner class TwoForOneOffers {

        @ParameterizedTest(name = "{0} eligible unit cost £{1}")
        @CsvSource(
            "2,2.50",
            "3, 5",
            "4,5.00"
        )
        fun `eligible units receive one free unit per pair`(quantity: Int, expectedTotal: String) {
            repeat(quantity) {
                cart.add(cornflakes)
            }
            cart.applyTwoForOneOffer(cornflakes.id)

            val receipt = cart.receipt()

            assertEquals(
                listOf(ReceiptLine(cornflakes, quantity = quantity)),
                receipt.lines
            )
            assertEquals(0, receipt.total.compareTo(BigDecimal(expectedTotal)))
        }
    }
}
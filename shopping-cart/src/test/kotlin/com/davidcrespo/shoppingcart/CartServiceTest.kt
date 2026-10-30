package com.davidcrespo.shoppingcart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertTrue

class CartServiceTest {

    private val service = CartService()
    private val cornflakes = Product("cornflakes", "Cornflakes", BigDecimal("2.50"))

    @Test
    fun `creating a cart makes an empty cart available`() {
        val cartId = service.createCart()

        val receipt = service.receipt(cartId)

        assert(receipt.lines.isEmpty())
        assertEquals(0, receipt.subtotal.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.discount.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.total.compareTo(BigDecimal.ZERO))
    }

    @Test
    fun `requesting a receipt for an unknown cart fails`() {
        val unknownCartId = UUID.randomUUID()

        assertThrows<CartNotFoundException> {
            service.receipt(unknownCartId)
        }
    }

    @Test
    fun `adding a product affects only the specified cart`() {
        val firstCartId = service.createCart()
        val secondCartId = service.createCart()

        service.addProduct(firstCartId, cornflakes)

        val firstReceipt = service.receipt(firstCartId)
        val secondReceipt = service.receipt(secondCartId)

        assertEquals(
            listOf(ReceiptLine(cornflakes, 1)),
            firstReceipt.lines
        )
        assertTrue(secondReceipt.lines.isEmpty())
        assertEquals(0, firstReceipt.total.compareTo(cornflakes.price))
        assertEquals(0, secondReceipt.total.compareTo(BigDecimal.ZERO))
    }

    @Test
    fun `removing a product through the service removes one unit`() {
        val cartId = service.createCart()
        service.addProduct(cartId, cornflakes)
        service.addProduct(cartId, cornflakes)

        service.removeProduct(cartId, cornflakes.id)

        val receipt = service.receipt(cartId)

        assertEquals(
            listOf(ReceiptLine(cornflakes, quantity = 1)),
            receipt.lines
        )
        assertEquals(0, receipt.total.compareTo(cornflakes.price))
    }

    @Test
    fun `applying an offer through the service discounts eligible products`() {
        val cartId = service.createCart()
        repeat(2) {
            service.addProduct(cartId, cornflakes)
        }

        service.applyTwoForOneOffer(cartId, cornflakes.id)

        val receipt = service.receipt(cartId)

        assertEquals(
            listOf(ReceiptLine(cornflakes, quantity = 2)),
            receipt.lines
        )
        assertEquals(0, receipt.subtotal.compareTo(BigDecimal("5.00")))
        assertEquals(0, receipt.discount.compareTo(BigDecimal("2.50")))
        assertEquals(0, receipt.total.compareTo(BigDecimal("2.50")))
    }


}
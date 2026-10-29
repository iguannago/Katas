package com.davidcrespo.shoppingcart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.util.UUID
import kotlin.test.assertTrue

class CartServiceTest {

    private val service = CartService()

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
        val cornflakes = Product("cornflakes", "Cornflakes", BigDecimal("2.50"))

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
}
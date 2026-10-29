package com.davidcrespo.shoppingcart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CartServiceTest {

    private val service: CartService = CartService()

    @Test
    fun `creating a cart makes an empty cart available`() {
        val cartId = service.createCart()

        val receipt = service.receipt(cartId)

        assert(receipt.lines.isEmpty())
        assertEquals(0, receipt.subtotal.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.discount.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.total.compareTo(BigDecimal.ZERO))
    }
}
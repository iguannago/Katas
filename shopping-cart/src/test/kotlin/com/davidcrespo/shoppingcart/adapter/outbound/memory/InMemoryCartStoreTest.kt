package com.davidcrespo.shoppingcart.adapter.outbound.memory

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class InMemoryCartStoreTest {
    private val store = InMemoryCartStore()

    @Test
    fun `creating a cart makes it available for an operation`() {
        val cartId = store.createCart()

        val receipt = store.withCart(cartId) { cart -> cart.receipt() }

        assertTrue(receipt.lines.isEmpty())
        assertEquals(0, receipt.subtotal.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.discount.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.total.compareTo(BigDecimal.ZERO))
    }
}
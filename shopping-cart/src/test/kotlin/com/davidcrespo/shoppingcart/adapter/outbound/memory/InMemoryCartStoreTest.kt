package com.davidcrespo.shoppingcart.adapter.outbound.memory

import com.davidcrespo.shoppingcart.application.CartNotFoundException
import com.davidcrespo.shoppingcart.domain.CartOwner
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal

class InMemoryCartStoreTest {
    private val store = InMemoryCartStore()

    private val alice = CartOwner(
        issuer = "http://localhost:8081/realms/shopping-carts",
        subject = "alice-subject"
    )

    private val bob = alice.copy(subject = "bob-subject")

    @Test
    fun `creating a cart makes it available for an operation`() {
        val cartId = store.createCart(alice)

        val receipt = store.withCart(cartId, alice) { cart -> cart.receipt() }

        assertTrue(receipt.lines.isEmpty())
        assertEquals(0, receipt.subtotal.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.discount.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.total.compareTo(BigDecimal.ZERO))
    }

    @Test
    fun `another owner cannot access a cart`() {
        val cartId = store.createCart(alice)
        var operationInvoked = false

        assertThrows<CartNotFoundException> {
            store.withCart(cartId, bob) {
                operationInvoked = true
            }
        }

        assertFalse(operationInvoked)
    }
}
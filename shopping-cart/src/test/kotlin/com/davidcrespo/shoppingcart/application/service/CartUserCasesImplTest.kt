package com.davidcrespo.shoppingcart.application.service

import com.davidcrespo.shoppingcart.adapter.outbound.memory.InMemoryCartStore
import com.davidcrespo.shoppingcart.application.CartNotFoundException
import com.davidcrespo.shoppingcart.application.port.output.CartStore
import com.davidcrespo.shoppingcart.domain.CartOwner
import com.davidcrespo.shoppingcart.domain.Product
import com.davidcrespo.shoppingcart.domain.ReceiptLine
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertTrue

class CartUserCasesImplTest {

    private val store: CartStore = InMemoryCartStore()
    private val service = CartUserCasesImpl(store)
    private val cornflakes = Product("cornflakes", "Cornflakes", BigDecimal("2.50"))

    private val alice = CartOwner(
        issuer = "http://localhost:8081/realms/shopping-cart",
        subject = "alice-subject"
    )

    private val bob = alice.copy(subject = "bob-subject")

    @Test
    fun `creating a cart makes an empty cart available`() {
        val cartId = service.createCart(alice)

        val receipt = service.receipt(cartId, alice)

        assert(receipt.lines.isEmpty())
        assertEquals(0, receipt.subtotal.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.discount.compareTo(BigDecimal.ZERO))
        assertEquals(0, receipt.total.compareTo(BigDecimal.ZERO))
    }

    @Test
    fun `another owner cannot add products to a cart`() {
        val cartId = service.createCart(alice)

        assertThrows<CartNotFoundException> {
            service.addProduct(cartId, bob, cornflakes)
        }

        val receipt = service.receipt(cartId, alice)

        assertTrue(receipt.lines.isEmpty())
        assertEquals(0, receipt.total.compareTo(BigDecimal.ZERO))
    }

    @Test
    fun `requesting a receipt for an unknown cart fails`() {
        val unknownCartId = UUID.randomUUID()

        assertThrows<CartNotFoundException> {
            service.receipt(unknownCartId, alice)
        }
    }

    @Test
    fun `adding a product affects only the specified cart`() {
        val firstCartId = service.createCart(alice)
        val secondCartId = service.createCart(alice)

        service.addProduct(firstCartId, alice, cornflakes)

        val firstReceipt = service.receipt(firstCartId, alice)
        val secondReceipt = service.receipt(secondCartId, alice)

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
        val cartId = service.createCart(alice)
        service.addProduct(cartId, alice, cornflakes)
        service.addProduct(cartId, alice, cornflakes)

        service.removeProduct(cartId, alice, cornflakes.id)

        val receipt = service.receipt(cartId, alice)

        assertEquals(
            listOf(ReceiptLine(cornflakes, quantity = 1)),
            receipt.lines
        )
        assertEquals(0, receipt.total.compareTo(cornflakes.price))
    }

    @Test
    fun `applying an offer through the service discounts eligible products`() {
        val cartId = service.createCart(alice)
        repeat(2) {
            service.addProduct(cartId, alice, cornflakes)
        }

        service.applyTwoForOneOffer(cartId, alice, cornflakes.id)

        val receipt = service.receipt(cartId, alice)

        assertEquals(
            listOf(ReceiptLine(cornflakes, quantity = 2)),
            receipt.lines
        )
        assertEquals(0, receipt.subtotal.compareTo(BigDecimal("5.00")))
        assertEquals(0, receipt.discount.compareTo(BigDecimal("2.50")))
        assertEquals(0, receipt.total.compareTo(BigDecimal("2.50")))
    }


}
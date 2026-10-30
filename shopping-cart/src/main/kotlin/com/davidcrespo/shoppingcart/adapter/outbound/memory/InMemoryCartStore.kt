package com.davidcrespo.shoppingcart.adapter.outbound.memory

import com.davidcrespo.shoppingcart.application.CartNotFoundException
import com.davidcrespo.shoppingcart.application.port.output.CartStore
import com.davidcrespo.shoppingcart.domain.ShoppingCart
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class InMemoryCartStore : CartStore {

    private val carts = ConcurrentHashMap<UUID, ShoppingCart>()

    override fun createCart(): UUID {
        while (true) {
            val cartId = UUID.randomUUID()
            if (carts.putIfAbsent(cartId, ShoppingCart()) == null) {
                return cartId
            }
        }
    }

    override fun <T> withCart(
        cartId: UUID,
        operation: (ShoppingCart) -> T
    ): T {
        val cart = carts[cartId]
            ?: throw CartNotFoundException(cartId)

        return synchronized(cart) {
            operation(cart)
        }
    }
}
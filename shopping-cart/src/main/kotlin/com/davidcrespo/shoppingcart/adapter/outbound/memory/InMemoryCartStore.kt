package com.davidcrespo.shoppingcart.adapter.outbound.memory

import com.davidcrespo.shoppingcart.application.CartNotFoundException
import com.davidcrespo.shoppingcart.application.port.output.CartStore
import com.davidcrespo.shoppingcart.domain.CartOwner
import com.davidcrespo.shoppingcart.domain.ShoppingCart
import java.util.*
import java.util.concurrent.ConcurrentHashMap

class InMemoryCartStore : CartStore {

    private data class OwnedCart(val owner: CartOwner, val cart: ShoppingCart)

    private val carts = ConcurrentHashMap<UUID, OwnedCart>()

    override fun createCart(owner: CartOwner): UUID {
        while (true) {
            val cartId = UUID.randomUUID()
            val ownedCart = OwnedCart(owner, ShoppingCart())
            if (carts.putIfAbsent(cartId, ownedCart) == null) {
                return cartId
            }
        }
    }

    override fun <T> withCart(
        cartId: UUID,
        owner: CartOwner,
        operation: (ShoppingCart) -> T
    ): T {
        val ownedCart = carts[cartId]
            ?: throw CartNotFoundException(cartId)

        if (ownedCart.owner != owner) {
            throw CartNotFoundException(cartId)
        }

        return synchronized(ownedCart.cart) {
            operation(ownedCart.cart)
        }
    }
}
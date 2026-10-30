package com.davidcrespo.shoppingcart

import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Service
class CartService {

    private val carts = ConcurrentHashMap<UUID, ShoppingCart>()

    fun createCart(): UUID {
        while (true) {
            val cartId = UUID.randomUUID()
            if (carts.putIfAbsent(cartId, ShoppingCart()) == null) {
                return cartId
            }
        }
    }

    fun receipt(cartId: UUID): Receipt {
        return withCart(cartId) { it.receipt() }
    }

    fun addProduct(cartId: UUID, product: Product) {
        withCart(cartId) { it.add(product) }
    }

    fun removeProduct(cartId: UUID, productId: String) {
        withCart(cartId) { it.remove(productId) }
    }

    fun applyTwoForOneOffer(cartId: UUID, productId: String) {
        withCart(cartId) { it.applyTwoForOneOffer(productId) }
    }

    private fun <T> withCart(cartId: UUID, operation: (ShoppingCart) -> T): T {
        val cart = carts[cartId] ?: throw CartNotFoundException(cartId)
        return synchronized(cart) {
            operation(cart)
        }
    }
}


class CartNotFoundException(cartId: UUID) : RuntimeException("Cart not found: $cartId")

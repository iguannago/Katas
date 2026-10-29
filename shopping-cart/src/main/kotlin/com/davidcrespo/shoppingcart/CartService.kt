package com.davidcrespo.shoppingcart

import org.springframework.stereotype.Service
import java.util.UUID
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
        val cart = carts[cartId] ?: throw CartNotFoundException(cartId)
        return synchronized(cart) {
            cart.receipt()
        }
    }

    fun addProduct(cartId: UUID, product: Product) {
        val cart = carts[cartId] ?: throw CartNotFoundException(cartId)

        synchronized(cart) {
            cart.add(product)
        }
    }

    fun removeProduct(cartId: UUID, productId: String) {
        val cart = carts[cartId] ?: throw CartNotFoundException(cartId)

        synchronized(cart) {
            cart.remove(productId)
        }
    }
}


class CartNotFoundException(cartId: UUID) : RuntimeException("Cart not found: $cartId")

package com.davidcrespo.shoppingcart

import java.math.BigDecimal

class ShoppingCart {
    private val quantities = mutableMapOf<String, Int>()

    fun add(product: Product) {
        quantities[product.id] = quantityOf(product.id) + 1
    }

    fun quantityOf(productId: String): Int {
        return quantities.getOrDefault(productId, 0)
    }

    fun remove(productId: String) {
        val quantity = quantityOf(productId)

        when {
            quantity > 1 -> quantities[productId] = quantity - 1
            quantity == 1 -> quantities.remove(productId)
        }
    }

    fun receipt(): Receipt =
        Receipt(
            lines = emptyList(),
            total = BigDecimal.ZERO
        )
}

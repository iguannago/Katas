package com.davidcrespo.shoppingcart

import java.math.BigDecimal
import kotlin.collections.fold

class ShoppingCart {

    private data class CartEntry(val product: Product, val quantity: Int)

    private val entries = mutableMapOf<String, CartEntry>()

    fun add(product: Product) {
        val existing = entries[product.id]

        entries[product.id] = CartEntry(
            product = existing?.product ?: product,
            quantity = quantityOf(product.id) + 1
        )
    }

    fun quantityOf(productId: String): Int {
        return entries[productId]?.quantity ?: 0
    }

    fun remove(productId: String) {
        val entry = entries[productId] ?: return

        if (entry.quantity > 1) {
            entries[productId] = entry.copy(quantity = entry.quantity - 1)
        } else {
            entries.remove(productId)
        }
    }

    fun receipt(): Receipt {
        val lines = entries.values.map { entry ->
            ReceiptLine(
                product = entry.product,
                quantity = entry.quantity
            )
        }

        val total = lines.fold(BigDecimal.ZERO) { sum, line ->
            sum + line.product.price.multiply(
                BigDecimal.valueOf(line.quantity.toLong())
            )
        }

        return Receipt(lines = lines, total = total)
    }
}

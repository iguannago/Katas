package com.davidcrespo.shoppingcart.domain

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.collections.fold

class ShoppingCart {

    private data class CartEntry(val product: Product, val quantity: Int)

    private val entries = mutableMapOf<String, CartEntry>()

    private val twoForOneProductIds = mutableSetOf<String>()
    private var twentyPercentOfferEnabled = false

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

        val subtotal = lines.fold(BigDecimal.ZERO) { sum, line ->
            sum + line.product.price.multiply(
                BigDecimal.valueOf(line.quantity.toLong())
            )
        }

        val twoForOneDiscount = lines.fold(BigDecimal.ZERO) { sum, line ->
            val freeQuantity =
                if (line.product.id in twoForOneProductIds) {
                    line.quantity / 2
                } else {
                    0
                }
            sum + line.product.price.multiply(
                BigDecimal.valueOf(freeQuantity.toLong())
            )
        }

        val percentageDiscount = if (twentyPercentOfferEnabled) {
            (subtotal - twoForOneDiscount)
                .multiply(BigDecimal("0.2"))
                .setScale(2, RoundingMode.HALF_UP)
        } else {
            BigDecimal.ZERO
        }

        return Receipt(
            lines = lines,
            subtotal = subtotal,
            discount = twoForOneDiscount + percentageDiscount,
        )
    }

    fun applyTwoForOneOffer(productId: String) {
        twoForOneProductIds.add(productId)
    }

    fun applyTwentyPercentOffer() {
        twentyPercentOfferEnabled = true
    }
}

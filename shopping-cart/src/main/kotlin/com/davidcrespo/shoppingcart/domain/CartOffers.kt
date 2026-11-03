package com.davidcrespo.shoppingcart.domain

import java.math.BigDecimal
import java.math.RoundingMode

class CartOffers {

    private val twoForOneProductIds = mutableSetOf<String>()
    private var twentyPercentEnabled = false

    fun enableTwoForOne(productId: String) {
        twoForOneProductIds.add(productId)
    }

    fun enableTwentyPercent() {
        twentyPercentEnabled = true
    }

    fun discount(
        lines: List<ReceiptLine>,
        subtotal: BigDecimal
    ): BigDecimal {
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

        val percentageDiscount =
            if (twentyPercentEnabled) {
                (subtotal - twoForOneDiscount)
                    .multiply(BigDecimal("0.20"))
                    .setScale(2, RoundingMode.HALF_UP)
            } else {
                BigDecimal.ZERO
            }

        return twoForOneDiscount + percentageDiscount
    }
}
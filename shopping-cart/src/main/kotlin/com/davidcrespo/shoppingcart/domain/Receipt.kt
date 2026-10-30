package com.davidcrespo.shoppingcart.domain

import java.math.BigDecimal

data class Receipt(
    val lines: List<ReceiptLine>,
    val subtotal: BigDecimal,
    val discount: BigDecimal,
) {
    val total: BigDecimal
        get() = subtotal.subtract(discount)
}

data class ReceiptLine(val product: Product, val quantity: Int)


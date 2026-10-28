package com.davidcrespo.shoppingcart

import java.math.BigDecimal

data class Receipt(
    val lines: List<ReceiptLine>,
    val total: BigDecimal
)

data class ReceiptLine(
    val product: Product,
    val quantity: Int
)

